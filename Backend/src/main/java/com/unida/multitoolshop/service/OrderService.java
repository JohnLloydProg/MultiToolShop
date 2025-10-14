package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllByCustomerId(int customerId);
    Order getById(int id);
    Order create(Order order);
}
