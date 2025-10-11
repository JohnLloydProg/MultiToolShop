package com.unida.multitoolshop.model;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String contactNumber;
    private Date birthdate;
    private Date created;
    private Date updated;
}
