package com.unida.multitoolshop.serviceimpl;

import com.unida.multitoolshop.entity.CartData;
import com.unida.multitoolshop.model.Cart;
import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.repository.CartDataRepository;
import com.unida.multitoolshop.service.CartService;
import com.unida.multitoolshop.util.Transformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@Service
public class CartServiceImpl implements CartService {
    Logger logger = Logger.getAnonymousLogger();

    @Autowired
    CartDataRepository cartDataRepository;

    @Override
    public Cart getCartByCustomer(Customer customer) {
        for (CartData cartData : cartDataRepository.findAll()) {
            if (Transformer.convert(cartData.getOwner()).equals(customer)) {
                logger.info("Returned Cart with id " + cartData.getId());
                return Transformer.convert(cartData);
            }
        }
        logger.info("Can't find Cart with customer id " + customer.getId());
        return null;
    }

    @Override
    public Cart create(Cart cart) {
        CartData cartData = Transformer.convert(cart);
        Cart newCart = Transformer.convert(cartDataRepository.save(cartData));
        logger.info("Created Cart with id " + newCart.getId());
        return newCart;
    }

    @Override
    public Cart update(Cart cart) {
        CartData cartData = Transformer.convert(cart);
        Cart newCart = Transformer.convert(cartDataRepository.save(cartData));
        logger.info("Updated Cart with id " + newCart.getId());
        return newCart;
    }

    @Override
    public void delete(Integer id) {
        Optional<CartData> cartData = cartDataRepository.findById(id);
        if (cartData.isPresent()) {
            logger.info("Deleted Cart with id " + cartData.get().getId());
            cartDataRepository.delete(cartData.get());
        }else {
            logger.info("Can't find cart with id " + id);
        }
    }
}
