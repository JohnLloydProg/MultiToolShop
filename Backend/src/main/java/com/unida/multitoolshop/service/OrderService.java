package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllByCustomer(Customer customer);
    Order getById(Integer id);
    Order create(Order order);
}
