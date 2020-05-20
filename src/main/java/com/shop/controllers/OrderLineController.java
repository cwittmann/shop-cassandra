package com.shop.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shop.models.OrderLine;
import com.shop.repositories.OrderLineRepository;

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
public class OrderLineController {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @GetMapping("/orderLines")
    public List<OrderLine> getOrderLines() {
        return orderLineRepository.findAll();
    }

    @GetMapping("/orderLinesOfOrder/{orderId}")
    public List<OrderLine> getOrderLinesOfOrder(@PathVariable UUID orderId) {
        return orderLineRepository.findByOrderId(orderId);
    }

    @GetMapping("/orderLines/{id}")
    public OrderLine getOrderLine(@PathVariable UUID id) {
        Optional<OrderLine> orderLine = orderLineRepository.findById(id);
        if (orderLine.isPresent()) {
            return orderLine.get();
        }
        return null;
    }

    @PostMapping("/orderLines")
    public OrderLine postOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineRepository.insert(orderLine);
    }

    @PutMapping("/orderLines")
    public OrderLine putOrderLine(@RequestBody OrderLine newOrder, @PathVariable UUID id) {
        Optional<OrderLine> orderLine = orderLineRepository.findById(id);
        if (orderLine.isPresent()) {
            return orderLineRepository.save(newOrder);
        }
        return null;
    }

    @DeleteMapping("/orderLines")
    public void deleteOrderLine(@PathVariable UUID id) {
        orderLineRepository.deleteById(id);
    }
}