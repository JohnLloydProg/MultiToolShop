package com.unida.multitoolshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unida.multitoolshop.model.Customer;
import com.unida.multitoolshop.model.MultiToolOption;
import com.unida.multitoolshop.model.MultiToolSet;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Customer customer;
    private Integer setId;
    @OneToMany
    @JoinColumn(name = "multiToolSetOptionData_id")
    private List<MultiToolSetOptionData> setOptions = new ArrayList<>();
    private float totalPrice;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date created;
}
