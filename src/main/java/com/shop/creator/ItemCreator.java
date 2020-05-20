package com.shop.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.datastax.driver.core.LocalDate;
import com.shop.models.Manufacturer;
import com.shop.models.OrderLine;
import com.shop.models.OrderStatus;
import com.shop.models.Orders;
import com.shop.models.Product;
import com.shop.models.User;
import com.shop.repositories.ManufacturerRepository;
import com.shop.repositories.OrderLineRepository;
import com.shop.repositories.OrdersRepository;
import com.shop.repositories.ProductRepository;
import com.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemCreator {

    private OrdersRepository orderRepository;
    private ManufacturerRepository manufacturerRepository;
    private ProductRepository productRepository;
    private OrderLineRepository orderLineRepository;
    private UserRepository userRepository;

    public ItemCreator(OrdersRepository orderRepository, ManufacturerRepository manufacturerRepository,
            ProductRepository productRepository, OrderLineRepository orderLineRepository,
            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
        this.orderLineRepository = orderLineRepository;
        this.userRepository = userRepository;
    }

    public Product getRandomProduct(List<Product> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public Orders getRandomOrder(List<Orders> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public User getRandomUser(List<User> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public void create() {

        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        List<Product> products = productRepository.findAll();
        List<Orders> orders = orderRepository.findAll();
        List<OrderLine> orderLines = orderLineRepository.findAll();
        List<User> users = userRepository.findAll();
    }
}