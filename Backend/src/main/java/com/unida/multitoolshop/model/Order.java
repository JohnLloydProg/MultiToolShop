package com.unida.multitoolshop.model;

import com.unida.multitoolshop.entity.SetOptionId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Integer id;
    private Customer customer;
    private Integer multiToolSetId;
    private List<SetOptionId> options;
    private Float totalPrice;
    private Date created;
}
