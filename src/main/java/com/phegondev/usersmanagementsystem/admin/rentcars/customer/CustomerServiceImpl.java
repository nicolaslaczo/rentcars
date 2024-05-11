package com.phegondev.usersmanagementsystem.admin.rentcars.customer;

import com.phegondev.usersmanagementsystem.admin.rentcars.rent.RentOrder;
import com.phegondev.usersmanagementsystem.admin.rentcars.rent.RentOrderRepository;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.Cars;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.CarsRepository;
import com.phegondev.usersmanagementsystem.admin.rentcars.images.Image;
import com.phegondev.usersmanagementsystem.admin.rentcars.images.ImageRepository;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.CarsDto;
import com.phegondev.usersmanagementsystem.handlers.CarsNotFoundException;
import com.phegondev.usersmanagementsystem.handlers.CustomerFoundException;
import com.phegondev.usersmanagementsystem.handlers.CustomerNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CarsRepository carsRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentOrderRepository rentOrderRepository;



    // --------------------- Customer only --------------- //

    public List<CarsDto> getAllVehicles() {
        List<Cars> carsList = carsRepository.findAll();
        return  carsList.stream().map(rentCars -> mapper.map(rentCars, CarsDto.class)).collect(Collectors.toList());
    }
    // View one vehicle
    public CarsDto getVehicleById(Long carId) {
        Cars cars = carsRepository.findById(carId).orElseThrow(() -> new CarsNotFoundException(carId));
        return mapper.map(cars, CarsDto.class);
     }

    // Get all images for car id

    public List<Image> getImagesByCarId(Long carId) {
        List<Image> imageList = imageRepository.findByCarsId(carId);
        if (imageList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return imageList;
        }
    }

    // Rent car
    @Transactional
    public void createNewRentOrder(Long carId, Customer customer) {

        Cars existingCar = carsRepository.findById(carId)
                .orElseThrow(() -> new CarsNotFoundException(carId));


        boolean customerExists = customerRepository.existsByEmail(customer.getEmail());

        if (!customerExists) {

            Customer savedCustomer = customerRepository.save(customer);


            RentOrder rentOrder = new RentOrder();
            rentOrder.setCars(existingCar);
            rentOrder.setCustomer(savedCustomer);
            rentOrderRepository.save(rentOrder);
        } else {

            Customer existingCustomer = customerRepository.findByEmail(customer.getEmail());
            RentOrder rentOrder = new RentOrder();
            rentOrder.setCars(existingCar);
            rentOrder.setCustomer(existingCustomer);


            rentOrderRepository.save(rentOrder);
        }
    }


    // ----------------- Admin only -------------------------//

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        if (customerList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return customerList;
        }
    }


    public void addNewCustomer(Customer customer) {
        boolean existByMail = customerRepository.existsByEmail(customer.getEmail());
        if (existByMail) {
            throw new  CustomerFoundException(customer.getEmail());
        } else {
            customerRepository.save(customer);
        }
    }

    public void deleteById(Long id) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        customerRepository.deleteById(id);
    }


























}
