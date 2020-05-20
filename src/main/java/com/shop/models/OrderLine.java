package com.shop.models;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderLine {

    @PrimaryKey
    public UUID id;
    public UUID orderId;
    public UUID productId;
    public Integer amount;
}