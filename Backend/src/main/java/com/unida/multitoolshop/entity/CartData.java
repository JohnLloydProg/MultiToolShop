package com.unida.multitoolshop.entity;


import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.model.MultiToolOption;
import com.unida.multitoolshop.model.MultiToolSet;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class CartData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customerData_id")
    private CustomerData owner;
    @ManyToOne
    @JoinColumn(name = "multiToolSetData_id")
    private MultiToolSetData multiToolSetData;
    @OneToMany
    @JoinColumn(name = "multiToolSetOptionData_id")
    private List<MultiToolSetOptionData> setOptions;
}
