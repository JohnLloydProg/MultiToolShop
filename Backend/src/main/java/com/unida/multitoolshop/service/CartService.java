package com.unida.multitoolshop.service;

import com.unida.multitoolshop.model.Cart;
import com.unida.multitoolshop.model.Customer;

import java.util.List;

public interface CartService {
    Cart getCartByCustomer(Customer customer );
}
