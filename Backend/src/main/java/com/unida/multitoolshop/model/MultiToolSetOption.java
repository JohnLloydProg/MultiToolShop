package com.unida.multitoolshop.model;


import lombok.Data;
import java.util.Date;

@Data
public class MultiToolSetOption {
    private Integer id;
    private MultiToolSet multiToolSet;
    private MultiToolOption multiToolOption;
    private Float addedPrice;
    private Date created;
    private Date updated;
}
