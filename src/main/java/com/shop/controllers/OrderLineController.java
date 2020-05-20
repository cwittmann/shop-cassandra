package com.shop.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shop.models.OrderLine;
import com.shop.repositories.OrderLineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderLineController {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @GetMapping("/orderLines")
    public List<OrderLine> getOrderLine() {
        return orderLineRepository.findAll();
    }

    @GetMapping("/orderLines/{id}")
    public OrderLine getOrder(@PathVariable UUID id) {
        Optional<OrderLine> orderLine = orderLineRepository.findById(id);
        if (orderLine.isPresent()) {
            return orderLine.get();
        }
        return null;
    }

    @PostMapping("/orderLines")
    public OrderLine postOrder(@RequestBody OrderLine orderLine) {
        return orderLineRepository.insert(orderLine);
    }

    @PutMapping("/orderLines")
    public OrderLine putOrder(@RequestBody OrderLine newOrder, @PathVariable UUID id) {
        Optional<OrderLine> orderLine = orderLineRepository.findById(id);
        if (orderLine.isPresent()) {
            return orderLineRepository.save(newOrder);
        }
        return null;
    }

    @DeleteMapping("/orderLines")
    public void deleteOrder(@PathVariable UUID id) {
        orderLineRepository.deleteById(id);
    }
}