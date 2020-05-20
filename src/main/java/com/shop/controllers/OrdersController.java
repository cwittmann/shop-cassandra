package com.shop.controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.datastax.driver.core.LocalDate;
import com.shop.models.OrderStatus;
import com.shop.models.Orders;
import com.shop.repositories.OrdersRepository;

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
    private OrdersRepository repository;

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return repository.findAll();
    }

    @GetMapping("/ordersCreate")
    public List<Orders> createOrders() {

        Orders order = new Orders(UUID.randomUUID(), UUID.randomUUID(), LocalDate.fromDaysSinceEpoch(1),
                OrderStatus.Created);

        repository.insert(order);

        return repository.findAll();
    }

    @GetMapping("/orders/{id}")
    public Orders getOrder(@PathVariable UUID id) {
        Optional<Orders> order = repository.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

    @PostMapping("/orders")
    public Orders postOrder(@RequestBody Orders order) {
        return repository.insert(order);
    }

    @PutMapping("/orders")
    public Orders putOrder(@RequestBody Orders newOrder, @PathVariable UUID id) {
        Optional<Orders> order = repository.findById(id);
        if (order.isPresent()) {
            return repository.save(newOrder);
        }
        return null;
    }

    @DeleteMapping("/orders")
    public void deleteOrder(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}