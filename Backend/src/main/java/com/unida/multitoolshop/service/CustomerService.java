package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getById(int id);
    List<Customer> getAll();
    Customer create(Customer customer);
    Customer update(Customer customer);
    Customer getByEmailPassword(String email, String password);
    void delete(int id);
}
