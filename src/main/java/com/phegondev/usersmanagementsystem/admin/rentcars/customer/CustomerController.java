package com.phegondev.usersmanagementsystem.admin.rentcars.customer;

import com.phegondev.usersmanagementsystem.admin.rentcars.images.Image;
import com.phegondev.usersmanagementsystem.admin.rentcars.images.ImageService;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.CarsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ImageService imageService;


    // ------------- Customer only --------------- //

    @GetMapping("/public/vehicles")
    public ResponseEntity<List<CarsDto>> getAllCars() {
        List<CarsDto> rentCarsList = customerService.getAllVehicles();
        return ResponseEntity.ok().body(rentCarsList);
    }

    @GetMapping("/public/vehicles/{carId}")
    public ResponseEntity<CarsDto> getRentCarsById(@PathVariable Long carId) {
        CarsDto carsDto = customerService.getVehicleById(carId);
        return ResponseEntity.ok().body(carsDto);
    }


    @GetMapping("public/vehicles/{carId}/images")
    public ResponseEntity<List<Image>> getImagesForCarId(@PathVariable Long carId) {
        List<Image> imageList = imageService.getImagesByCarId(carId);
        return ResponseEntity.ok().body(imageList);
    }


    @PostMapping("/public/vehicles/{carId}/rent")
    public ResponseEntity<HttpStatus> createNewRentOrder(@PathVariable Long carId,@RequestBody Customer customer) {
        customerService.createNewRentOrder(carId,customer);
        return ResponseEntity.ok().build();
    }


    // ------------------- Admin only ----------------------/
    @GetMapping("/admin/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return ResponseEntity.ok().body(customerList);
    }


    @PostMapping("/admin/customer")
    public ResponseEntity<HttpStatus> addNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/admin/customer/{customerId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long customerId) {
        customerService.deleteById(customerId);
        return ResponseEntity.ok().build();
    }













}
