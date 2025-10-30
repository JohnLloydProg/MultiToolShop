package com.unida.multitoolshop.model;

import com.unida.multitoolshop.enumerations.OrderStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private int id;
    private MultiToolSet multiToolSet;
    private Customer customer;
    private List<SetOption> options;
    private Float totalPrice;
    private OrderStatus status;
    private Date created;
}
