package com.shop.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import com.shop.models.Orders;
import com.shop.models.OrderStatus;
import com.shop.repositories.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrdersRepository repository;

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return repository.findAll();
    }

}