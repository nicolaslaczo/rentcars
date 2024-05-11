package com.phegondev.usersmanagementsystem.admin.rentcars.config;

import com.phegondev.usersmanagementsystem.admin.rentcars.rent.RentOrderMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RentOrderMapper rentOrderMapper(ModelMapper modelMapper) {
        return new RentOrderMapper(modelMapper);
    }
}
