package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;

@Data
public class MultiToolOption {
    private int id;
    private String name;
    private int categoryId;
    private String categoryName;
    private boolean multiple;
    private Date updated;
    private Date created;
}
