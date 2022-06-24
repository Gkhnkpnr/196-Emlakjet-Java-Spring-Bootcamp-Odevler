package com.example.rabbitmqproducer.business;

import com.example.rabbitmqproducer.dao.SaleAdvertisementRepository;
import com.example.rabbitmqproducer.dao.UserRepository;
import com.example.rabbitmqproducer.dto.SaleAdvertisementDTO;
import com.example.rabbitmqproducer.entity.SaleAdvertisement;
import com.example.rabbitmqproducer.entity.User;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleAdvertisementServiceImpl implements SaleAdvertisementService{
    private SaleAdvertisementRepository saleAdvertisementRepository;
    private UserRepository userRepository;
    private RabbitTemplate rabbitTemplate;
    private Queue queue;

    @Autowired
    public SaleAdvertisementServiceImpl(SaleAdvertisementRepository saleAdvertisementRepository, UserRepository userRepository, RabbitTemplate rabbitTemplate, Queue queue) {
        this.saleAdvertisementRepository = saleAdvertisementRepository;
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public String createSaleAdvertisement(SaleAdvertisementDTO saleAdvertisementDTO) {
        User user = User.builder()
                .username(saleAdvertisementDTO.getUsername())
                .email(saleAdvertisementDTO.getEmail())
                .build();
        User userDB = userRepository.save(user);

        SaleAdvertisement saleAdvertisement = SaleAdvertisement.builder()
                .title(saleAdvertisementDTO.getTitle())
                .photo(saleAdvertisementDTO.getPhoto())
                .detailMessage(saleAdvertisementDTO.getDetailMessage())
                .build();
        SaleAdvertisement saleAdvertisementDB = saleAdvertisementRepository.save(saleAdvertisement);

        rabbitTemplate.convertAndSend(queue.getName(), saleAdvertisementDB);

        return "";
    }

    @Override
    public List<SaleAdvertisement> getAll() {
        return saleAdvertisementRepository.findAll();
    }
}
