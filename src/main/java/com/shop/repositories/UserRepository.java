package com.shop.repositories;

import java.util.UUID;

import com.shop.models.User;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository extends CassandraRepository<User, UUID> {

}