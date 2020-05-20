package com.shop.models;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Manufacturer {

    @PrimaryKey
    public UUID id;
    public String name;

    public Manufacturer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}