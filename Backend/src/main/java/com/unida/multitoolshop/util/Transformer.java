package com.unida.multitoolshop.util;

import com.unida.multitoolshop.entity.*;
import com.unida.multitoolshop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    public static Cart convert(CartData cartData) {
        Cart cart = new Cart();
        cart.setId(cartData.getId());
        cart.setOwner(Transformer.convert(cartData.getOwner()));
        cart.setMultiToolSet(Transformer.convert(cartData.getMultiToolSetData()));
        List<MultiToolSetOption> multiToolSetOptionList = new ArrayList<>();
        for (MultiToolSetOptionData multiToolSetOptionData : cartData.getSetOptions()) {
            multiToolSetOptionList.add(Transformer.convert(multiToolSetOptionData));
        }
        cart.setOptions(multiToolSetOptionList);
        return cart;
    }

    public static CartData convert(Cart cart) {
        CartData cartData = new CartData();
        cartData.setId(cart.getId());
        cartData.setOwner(Transformer.convert(cart.getOwner()));
        cartData.setMultiToolSetData(Transformer.convert(cart.getMultiToolSet()));
        List<MultiToolSetOptionData> multiToolSetOptionData = new ArrayList<>();
        for (MultiToolSetOption multiToolSetOption : cart.getOptions()) {
            multiToolSetOptionData.add(Transformer.convert(multiToolSetOption));
        }
        cartData.setSetOptions(multiToolSetOptionData);
        return cartData;
    }

    public static Order convert(OrderData orderData) {
        Order order = new Order();
        order.setId(orderData.getId());
        order.setCustomer(Transformer.convert(orderData.getCustomerData()));
        order.setMultiToolSetId(orderData.getMultiToolSetId());
        List<MultiToolSetOption> multiToolOptionList = new ArrayList<>();
        order.setOptions(orderData.getSetOptions());
        order.setTotalPrice(orderData.getTotalPrice());
        order.setCreated(orderData.getCreated());
        return order;
    }

    public static OrderData convert(Order order) {
        OrderData orderData = new OrderData();
        orderData.setId(order.getId());
        orderData.setCustomerData(Transformer.convert(order.getCustomer()));
        orderData.setMultiToolSetId(order.getMultiToolSetId());
        orderData.setSetOptions(order.getOptions());
        orderData.setTotalPrice(order.getTotalPrice());
        orderData.setCreated(order.getCreated());
        return orderData;
    }

    public static Customer convert(CustomerData customerData) {
        Customer customer = new Customer();
        customer.setId(customerData.getId());
        customer.setFirstName(customerData.getFirstName());
        customer.setMiddleName(customerData.getMiddleName());
        customer.setLastName(customerData.getLastName());
        customer.setEmail(customerData.getEmail());
        customer.setPassword(customerData.getPassword());
        customer.setAddress(customerData.getAddress());
        customer.setContactNumber(customerData.getContactNumber());
        customer.setBirthdate(customerData.getBirthdate());
        customer.setCreated(customerData.getCreated());
        customer.setUpdated(customerData.getUpdated());
        return customer;
    }

    public static CustomerData convert(Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setMiddleName(customer.getMiddleName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        customerData.setPassword(customer.getPassword());
        customerData.setAddress(customer.getAddress());
        customerData.setContactNumber(customer.getContactNumber());
        customerData.setBirthdate(customer.getBirthdate());
        customerData.setCreated(customer.getCreated());
        customerData.setUpdated(customer.getUpdated());
        return customerData;
    }

    public static MultiToolSetData convert(MultiToolSet multiToolSet) {
        MultiToolSetData multiToolSetData = new MultiToolSetData();
        multiToolSetData.setId(multiToolSet.getId());
        multiToolSetData.setName(multiToolSet.getName());
        multiToolSetData.setDescription(multiToolSet.getDescription());
        List<MultiToolSetOptionData> options = new ArrayList<>();
        for (MultiToolSetOption setOption : multiToolSet.getOptions()) {
            MultiToolSetOptionData multiToolSetOptionData = Transformer.convert(setOption);
            multiToolSetOptionData.setMultiToolSetData(multiToolSetData);
            options.add(multiToolSetOptionData);
        }
        multiToolSetData.setSetOptions(options);
        multiToolSetData.setImages(multiToolSet.getImages());
        multiToolSetData.setBasePrice(multiToolSet.getBasePrice());
        multiToolSetData.setCreated(multiToolSet.getCreated());
        multiToolSetData.setUpdated(multiToolSet.getUpdated());
        return multiToolSetData;
    }

    public static MultiToolOptionData convert(MultiToolOption multiToolOption) {
        MultiToolOptionData multiToolOptionData = new MultiToolOptionData();
        multiToolOptionData.setId(multiToolOption.getId());
        multiToolOptionData.setName(multiToolOption.getName());
        multiToolOptionData.setOptionCategoryData(Transformer.convert(multiToolOption.getCategory()));
        multiToolOptionData.setImage(multiToolOption.getImage());
        multiToolOptionData.setCreated(multiToolOption.getCreated());
        multiToolOptionData.setUpdated(multiToolOption.getUpdated());
        return multiToolOptionData;
    }

    public static OptionCategoryData convert(OptionCategory optionCategory) {
        OptionCategoryData optionCategoryData = new OptionCategoryData();
        optionCategoryData.setId(optionCategory.getId());
        optionCategoryData.setName(optionCategory.getName());
        optionCategoryData.setCreated(optionCategory.getCreated());
        optionCategoryData.setUpdated(optionCategory.getUpdated());
        return optionCategoryData;
    }

    public static MultiToolSetOptionData convert(MultiToolSetOption multiToolSetOption) {
        MultiToolSetOptionData multiToolSetOptionData = new MultiToolSetOptionData();
        multiToolSetOptionData.setId(multiToolSetOption.getId());
        multiToolSetOptionData.setMultiToolOption(Transformer.convert(multiToolSetOption.getMultiToolOption()));
        multiToolSetOptionData.setAddedPrice(multiToolSetOption.getAddedPrice());
        multiToolSetOptionData.setCreated(multiToolSetOption.getCreated());
        multiToolSetOptionData.setUpdated(multiToolSetOption.getUpdated());
        return multiToolSetOptionData;
    }

    public static MultiToolSet convert(MultiToolSetData multiToolSetData) {
        MultiToolSet multiToolSet = new MultiToolSet();
        multiToolSet.setId(multiToolSetData.getId());
        multiToolSet.setName(multiToolSetData.getName());
        multiToolSet.setDescription(multiToolSetData.getDescription());
        List<MultiToolSetOption> options = new ArrayList<>();
        for (MultiToolSetOptionData setOptionData : multiToolSetData.getSetOptions()) {
            MultiToolSetOption multiToolSetOption = Transformer.convert(setOptionData);
            multiToolSetOption.setMultiToolSet(multiToolSet);
            options.add(multiToolSetOption);
        }
        multiToolSet.setOptions(options);
        multiToolSet.setImages(multiToolSetData.getImages());
        multiToolSet.setBasePrice(multiToolSetData.getBasePrice());
        multiToolSet.setCreated(multiToolSetData.getCreated());
        multiToolSet.setUpdated(multiToolSetData.getUpdated());
        return multiToolSet;
    }

    public static MultiToolOption convert(MultiToolOptionData multiToolOptionData) {
        MultiToolOption multiToolOption = new MultiToolOption();
        multiToolOption.setId(multiToolOptionData.getId());
        multiToolOption.setName(multiToolOptionData.getName());
        multiToolOption.setCategory(Transformer.convert(multiToolOptionData.getOptionCategoryData()));
        multiToolOption.setImage(multiToolOptionData.getImage());
        multiToolOption.setCreated(multiToolOptionData.getCreated());
        multiToolOption.setUpdated(multiToolOptionData.getUpdated());
        return multiToolOption;
    }

    public static OptionCategory convert(OptionCategoryData optionCategoryData) {
        OptionCategory optionCategory = new OptionCategory();
        optionCategory.setId(optionCategoryData.getId());
        optionCategory.setName(optionCategoryData.getName());
        optionCategory.setCreated(optionCategoryData.getCreated());
        optionCategory.setUpdated(optionCategoryData.getUpdated());
        return optionCategory;
    }

    public static MultiToolSetOption convert(MultiToolSetOptionData multiToolSetOptionData) {
        MultiToolSetOption multiToolSetOption = new MultiToolSetOption();
        multiToolSetOption.setId(multiToolSetOptionData.getId());
        multiToolSetOption.setMultiToolOption(Transformer.convert(multiToolSetOptionData.getMultiToolOption()));
        multiToolSetOption.setAddedPrice(multiToolSetOptionData.getAddedPrice());
        multiToolSetOption.setCreated(multiToolSetOptionData.getCreated());
        multiToolSetOption.setUpdated(multiToolSetOptionData.getUpdated());
        return multiToolSetOption;
    }
}