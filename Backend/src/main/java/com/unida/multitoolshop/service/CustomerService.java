package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.Customer;

public interface CustomerService {
    Customer getById(int id);
    Customer create(Customer customer);
    Customer update(Customer customer);
    void delete(int id);
}
