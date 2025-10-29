package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class MultiToolSet {
    private int id;
    private String name;
    private String description;
    private String image;
    private int customizations;
    private int orders;
    private int stock;
    private Float basePrice;
    private Date created;
    private Date updated;
}
