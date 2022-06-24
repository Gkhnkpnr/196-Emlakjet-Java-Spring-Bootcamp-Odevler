package com.example.rabbitmqproducer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SaleAdvertisementDTO implements Serializable {
    private String title;
    private String photo;
    private String detailMessage;
    private String username;
    private String email;
}
