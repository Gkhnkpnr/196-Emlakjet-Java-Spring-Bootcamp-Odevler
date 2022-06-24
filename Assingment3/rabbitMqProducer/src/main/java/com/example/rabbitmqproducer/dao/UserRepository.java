package com.example.rabbitmqproducer.dao;

import com.example.rabbitmqproducer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
