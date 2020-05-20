package com.shop.models;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table
@Data

public class OrderLine {

    @PrimaryKey
    public UUID id;
    public UUID orderId;
    public UUID productId;
    public Integer amount;

    public OrderLine(UUID id, UUID orderId, UUID productId, Integer amount) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
    }
}