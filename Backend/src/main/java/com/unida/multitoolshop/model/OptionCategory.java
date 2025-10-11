package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;

@Data
public class OptionCategory {
    private Integer id;
    private String name;
    private Date created;
    private Date updated;
}
