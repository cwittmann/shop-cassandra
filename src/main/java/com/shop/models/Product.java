package com.shop.models;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table
@Data

public class Product {

    @PrimaryKey
    public UUID id;
    public UUID manufacturerId;
    public String name;
    public String description;
    public String price;

    public Product(UUID id, UUID manufacturerId, String name, String description, String price) {
        this.id = id;
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}