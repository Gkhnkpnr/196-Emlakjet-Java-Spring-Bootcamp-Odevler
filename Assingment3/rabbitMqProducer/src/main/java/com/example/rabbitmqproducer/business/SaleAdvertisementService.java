package com.example.rabbitmqproducer.business;

import com.example.rabbitmqproducer.dto.SaleAdvertisementDTO;
import com.example.rabbitmqproducer.entity.SaleAdvertisement;

import java.util.List;

public interface SaleAdvertisementService {
    String createSaleAdvertisement(SaleAdvertisementDTO saleAdvertisementDTO);
    List<SaleAdvertisement> getAll();
}
