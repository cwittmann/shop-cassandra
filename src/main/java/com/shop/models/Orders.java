package com.shop.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Orders {

    @PrimaryKey
    public UUID id;
    public UUID userId;
    public Date date;
    public OrderStatus status;

    public Orders(UUID id, UUID userId, Date date, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.status = status;
    }
}