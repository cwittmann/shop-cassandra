package com.shop.controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shop.creator.ItemCreator;
import com.shop.models.Orders;
import com.shop.repositories.ManufacturerRepository;
import com.shop.repositories.OrderLineRepository;
import com.shop.repositories.OrdersRepository;
import com.shop.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrdersRepository orderRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/ordersCreate")
    public void createOrders() {

        ItemCreator itemCreator = new ItemCreator(orderRepository, manufacturerRepository, productRepository,
                orderLineRepository);
        itemCreator.create();
    }

    @GetMapping("/orders/{id}")
    public Orders getOrder(@PathVariable UUID id) {
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

    @PostMapping("/orders")
    public Orders postOrder(@RequestBody Orders order) {
        return orderRepository.insert(order);
    }

    @PutMapping("/orders")
    public Orders putOrder(@RequestBody Orders newOrder, @PathVariable UUID id) {
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return orderRepository.save(newOrder);
        }
        return null;
    }

    @DeleteMapping("/orders")
    public void deleteOrder(@PathVariable UUID id) {
        orderRepository.deleteById(id);
    }
}