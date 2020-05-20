package com.shop.repositories;

import java.util.List;
import java.util.UUID;

import com.shop.models.OrderLine;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface OrderLineRepository extends CassandraRepository<OrderLine, UUID> {

    @AllowFiltering
    public List<OrderLine> findByOrderId(UUID orderId);

}