package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private int id;
    private Customer customer;
    private List<SetOption> options;
    private Float totalPrice;
    private Date created;
}
