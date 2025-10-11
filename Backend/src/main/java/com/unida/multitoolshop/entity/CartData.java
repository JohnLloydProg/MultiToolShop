package com.unida.multitoolshop.entity;


import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.model.MultiToolOption;
import com.unida.multitoolshop.model.MultiToolSet;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class CartData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Customer owner;
    private MultiToolSet multiToolSet;
    private List<MultiToolOption> options;
}
