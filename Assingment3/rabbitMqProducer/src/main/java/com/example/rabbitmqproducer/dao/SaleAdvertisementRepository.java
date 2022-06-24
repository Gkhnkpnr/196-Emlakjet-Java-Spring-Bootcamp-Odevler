package com.example.rabbitmqproducer.dao;

import com.example.rabbitmqproducer.entity.SaleAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleAdvertisementRepository extends JpaRepository<SaleAdvertisement, Long> {
}
