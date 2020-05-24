package com.shop.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shop.models.Orders;
import com.shop.repositories.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrdersController {

    @Autowired
    private OrdersRepository orderRepository;

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return orderRepository.findAll();
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