package com.example.rabbitmqproducer.controller;

import com.example.rabbitmqproducer.business.SaleAdvertisementService;
import com.example.rabbitmqproducer.dto.SaleAdvertisementDTO;
import com.example.rabbitmqproducer.entity.SaleAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleAdvertisementController {
    private SaleAdvertisementService saleAdvertisementService;

    @Autowired
    public SaleAdvertisementController(SaleAdvertisementService saleAdvertisementService) {
        this.saleAdvertisementService = saleAdvertisementService;
    }

    @PostMapping("/sale-advertisement")
    public String createSaleAdvertisement(@RequestBody SaleAdvertisementDTO saleAdvertisementDTO){
        saleAdvertisementService.createSaleAdvertisement(saleAdvertisementDTO);
        return "Talebiniz alindi";
    }

    public List<SaleAdvertisement> getAll(){
        return saleAdvertisementService.getAll();
    }
}
