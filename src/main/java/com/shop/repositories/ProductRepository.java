package com.shop.repositories;

import java.util.UUID;

import com.shop.models.Product;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

}