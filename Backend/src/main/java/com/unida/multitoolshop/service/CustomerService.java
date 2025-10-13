package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.Customer;

public interface CustomerService {
    Customer getById(Integer id);
    Customer create(Customer customer);
    Customer update(Customer customer);
    void delete(Integer id);
}
