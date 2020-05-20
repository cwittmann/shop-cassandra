package com.shop.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.shop.models.Manufacturer;
import com.shop.repositories.ManufacturerRepository;

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
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturers")
    public List<Manufacturer> getManufacturer() {
        return manufacturerRepository.findAll();
    }

    @GetMapping("/manufacturers/{id}")
    public Manufacturer getOrder(@PathVariable UUID id) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
        if (manufacturer.isPresent()) {
            return manufacturer.get();
        }
        return null;
    }

    @PostMapping("/manufacturers")
    public Manufacturer postOrder(@RequestBody Manufacturer manufacturer) {
        return manufacturerRepository.insert(manufacturer);
    }

    @PutMapping("/manufacturers")
    public Manufacturer putOrder(@RequestBody Manufacturer newOrder, @PathVariable UUID id) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
        if (manufacturer.isPresent()) {
            return manufacturerRepository.save(newOrder);
        }
        return null;
    }

    @DeleteMapping("/manufacturers")
    public void deleteOrder(@PathVariable UUID id) {
        manufacturerRepository.deleteById(id);
    }
}