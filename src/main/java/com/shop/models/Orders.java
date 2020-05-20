package com.shop.models;

import java.util.UUID;

import com.datastax.driver.core.LocalDate;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Orders {

    @PrimaryKey
    public UUID id;
    public UUID userId;
    public LocalDate date;
    public OrderStatus status;

    public Orders(UUID id, UUID userId, LocalDate date, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.status = status;
    }
}