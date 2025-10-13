package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private Integer id;
    private Customer owner;
    private MultiToolSet multiToolSet;
    private List<MultiToolSetOption> options;
}
