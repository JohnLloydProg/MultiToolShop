package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;

@Data
public class MultiToolOption {
    private Integer id;
    private String name;
    private OptionCategory category;
    private String image;
    private Float addedPrice;
    private Date created;
    private Date updated;
}
