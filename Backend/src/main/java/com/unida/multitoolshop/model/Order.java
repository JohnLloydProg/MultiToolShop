package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private int id;
    private Customer customer;
    private int multiToolSetId;
    private List<Integer> options;
    private Float totalPrice;
    private Date created;
}
