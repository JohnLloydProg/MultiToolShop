package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MultiToolSet {
    private Integer id;
    private String name;
    private String description;
    private List<MultiToolOption> options;
    private Float basePrice;
    private Date created;
    private Date updated;
}
