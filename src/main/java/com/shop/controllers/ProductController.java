package com.shop.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shop.models.Product;
import com.shop.repositories.ProductRepository;

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
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getOrder(@PathVariable UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @PostMapping("/products")
    public Product postOrder(@RequestBody Product product) {
        return productRepository.insert(product);
    }

    @PutMapping("/products")
    public Product putOrder(@RequestBody Product newOrder, @PathVariable UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return productRepository.save(newOrder);
        }
        return null;
    }

    @DeleteMapping("/products")
    public void deleteOrder(@PathVariable UUID id) {
        productRepository.deleteById(id);
    }
}