package com.shop.repositories;

import java.util.UUID;

import com.shop.models.Orders;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface OrdersRepository extends CassandraRepository<Orders, UUID> {
}