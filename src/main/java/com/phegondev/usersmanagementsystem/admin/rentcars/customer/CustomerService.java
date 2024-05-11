package com.phegondev.usersmanagementsystem.admin.rentcars.customer;

import com.phegondev.usersmanagementsystem.admin.rentcars.images.Image;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.CarsDto;

import java.util.List;

public interface CustomerService {

    // Customer only ----------------------------------------------- //

    List<CarsDto> getAllVehicles();

    CarsDto getVehicleById(Long carId);

    List<Image> getImagesByCarId(Long carId);

    void createNewRentOrder(Long cardId, Customer customer);

    // Admin only ---------------------------------------------------- //

    List<Customer> getAllCustomers();

    void addNewCustomer(Customer customer);

    void deleteById(Long id);
}
