package com.shop.repositories;

import java.util.UUID;

import com.shop.models.OrderLine;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface OrderLineRepository extends CassandraRepository<OrderLine, UUID> {

}