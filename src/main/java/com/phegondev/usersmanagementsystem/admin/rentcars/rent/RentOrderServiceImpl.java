package com.phegondev.usersmanagementsystem.admin.rentcars.rent;

import com.phegondev.usersmanagementsystem.admin.rentcars.customer.Customer;
import com.phegondev.usersmanagementsystem.admin.rentcars.customer.CustomerRepository;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.Cars;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentOrderServiceImpl implements RentOrderService {

    @Autowired
    private RentOrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CarsRepository carsRepository;
    @Autowired
    private RentOrderMapper rentOrderMapper;



    // --------------------- ADMIN -----------------------------//
    // Get all orders

    public List<RentOrderDto> getAllOrdersWithDetails() {
        List<RentOrder> rentOrderList = orderRepository.findAll();
        return rentOrderList.stream()
                .map(rentOrder -> {
                    RentOrderDto rentOrderDto = rentOrderMapper.toDto(rentOrder);
                    rentOrderDto.setOrderStatus(rentOrder.getStatus());
                    return rentOrderDto;
                })
                .collect(Collectors.toList());
    }



































}
