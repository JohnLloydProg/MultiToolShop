package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;

@Data
public class MultiToolOption {
    private Integer id;
    private String name;
    private OptionCategory category;
    private String image;
    private Date updated;
    private Date created;
}
