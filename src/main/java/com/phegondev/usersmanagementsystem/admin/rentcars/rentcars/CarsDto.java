package com.phegondev.usersmanagementsystem.admin.rentcars.rentcars;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarsDto {

    private Long id;
    private String brand;
    private String model;

    private Integer year;

    private Integer rentPrice;
    private String gearbox;
    private boolean availability;
    private String description;
    private String image;


}
