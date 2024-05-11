package com.phegondev.usersmanagementsystem.admin.rentcars.rent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RentOrderDto {

    private Long id;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerPhoneNum;
    private String carBrand;
    private String carModel;
    private String carVin;
    private Integer carRentPrice;
    private OrderStatus orderStatus;



}
