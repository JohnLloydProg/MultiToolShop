package com.unida.multitoolshop.model;


import com.unida.multitoolshop.entity.SetOptionId;
import lombok.Data;
import java.util.Date;

@Data
public class MultiToolSetOption {
    private SetOptionId id;
    private MultiToolSet multiToolSet;
    private MultiToolOption multiToolOption;
    private Float addedPrice;
    private Date created;
    private Date updated;
}
