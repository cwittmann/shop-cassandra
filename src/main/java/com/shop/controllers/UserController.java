package com.shop.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shop.models.User;
import com.shop.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getOrder(@PathVariable UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @PostMapping("/users")
    public User postOrder(@RequestBody User user) {
        return userRepository.insert(user);
    }

    @PutMapping("/users")
    public User putOrder(@RequestBody User newOrder, @PathVariable UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userRepository.save(newOrder);
        }
        return null;
    }

    @DeleteMapping("/users")
    public void deleteOrder(@PathVariable UUID id) {
        userRepository.deleteById(id);
    }
}