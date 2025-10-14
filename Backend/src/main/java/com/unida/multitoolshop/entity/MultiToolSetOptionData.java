package com.unida.multitoolshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unida.multitoolshop.model.MultiToolOption;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class MultiToolSetOptionData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int setId;
    private int optionId;
    private Float addedPrice;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date updated;

}
