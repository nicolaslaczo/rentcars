package com.phegondev.usersmanagementsystem.admin.rentcars.rent;

import com.phegondev.usersmanagementsystem.admin.rentcars.customer.Customer;
import com.phegondev.usersmanagementsystem.admin.rentcars.customer.CustomerRepository;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.Cars;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentOrderServiceImpl implements RentOrderService {

    @Autowired
    private RentOrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CarsRepository carsRepository;



    // --------------------- ADMIN -----------------------------//
    // Get all orders

    public List<RentOrder> getAllOrdersWithDetails() {
        List<RentOrder> rentOrderList = orderRepository.findAll();
        return rentOrderList;
    }


































}
