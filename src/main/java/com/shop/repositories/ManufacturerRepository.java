package com.shop.repositories;

import java.util.UUID;

import com.shop.models.Manufacturer;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ManufacturerRepository extends CassandraRepository<Manufacturer, UUID> {
}