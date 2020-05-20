package com.shop.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.datastax.driver.core.LocalDate;
import com.shop.models.Manufacturer;
import com.shop.models.OrderStatus;
import com.shop.models.Orders;
import com.shop.repositories.ManufacturerRepository;
import com.shop.repositories.OrderLineRepository;
import com.shop.repositories.OrdersRepository;
import com.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemCreator {

    private OrdersRepository orderRepository;
    private ManufacturerRepository manufacturerRepository;
    private ProductRepository productRepository;
    private OrderLineRepository orderLineRepository;

    public ItemCreator(OrdersRepository orderRepository, ManufacturerRepository manufacturerRepository,
            ProductRepository productRepository, OrderLineRepository orderLineRepository) {
        this.orderRepository = orderRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
        this.orderLineRepository = orderLineRepository;
    }

    public void create() {
        /*
         * List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
         * manufacturers.add(new Manufacturer(UUID.randomUUID(), "Apple"));
         * manufacturers.add(new Manufacturer(UUID.randomUUID(), "Asus"));
         * manufacturers.add(new Manufacturer(UUID.randomUUID(), "HP"));
         * manufacturers.add(new Manufacturer(UUID.randomUUID(), "IBM"));
         * manufacturers.add(new Manufacturer(UUID.randomUUID(), "Logitech"));
         * manufacturers.add(new Manufacturer(UUID.randomUUID(), "Lenovo"));
         * manufacturers.add(new Manufacturer(UUID.randomUUID(), "Samsung"));
         * 
         * for (Manufacturer manufacturer : manufacturers) {
         * manufacturerRepository.insert(manufacturer); }
         */

        /*
         * Orders order = new Orders(UUID.randomUUID(), UUID.randomUUID(),
         * LocalDate.fromDaysSinceEpoch(1), OrderStatus.Created);
         * 
         * orderRepository.insert(order);
         */
    }
}