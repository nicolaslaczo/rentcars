package com.phegondev.usersmanagementsystem.admin.rentcars.rent;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentOrderMapper {

    private final ModelMapper modelMapper;
    @Autowired
    public RentOrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        configureMapper();
    }

    private void configureMapper() {
        modelMapper.addMappings(new PropertyMap<RentOrder, RentOrderDto>() {
            @Override
            protected void configure() {
                map().setCustomerFirstName(source.getCustomer().getFirstName());
                map().setCustomerLastName(source.getCustomer().getLastName());
                map().setCustomerEmail(source.getCustomer().getEmail());
                map().setCustomerPhoneNum(source.getCustomer().getPhoneNum());
                map().setCarBrand(source.getCars().getBrand());
                map().setCarModel(source.getCars().getModel());
                map().setCarVin(source.getCars().getVin());
                map().setCarRentPrice(source.getCars().getRentPrice());


            }
        });
    }

    public RentOrderDto toDto(RentOrder rentOrder) {
        return modelMapper.map(rentOrder, RentOrderDto.class);
    }
}
