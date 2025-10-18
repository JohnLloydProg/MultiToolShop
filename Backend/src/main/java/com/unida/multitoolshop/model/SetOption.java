package com.unida.multitoolshop.model;


import lombok.Data;

import java.util.Date;

@Data
public class SetOption {
    private int id;
    private MultiToolSet multiToolSet;
    private MultiToolOption multiToolOption;
    private Float addedPrice;
    private Date created;
    private Date updated;
}
