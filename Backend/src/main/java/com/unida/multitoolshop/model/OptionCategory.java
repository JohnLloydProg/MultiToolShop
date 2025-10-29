package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;

@Data
public class OptionCategory {
    private int id;
    private String name;
    private boolean multiple;
    private Date created;
}
