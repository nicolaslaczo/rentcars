package com.phegondev.usersmanagementsystem.admin.rentcars.rentcars;

import com.phegondev.usersmanagementsystem.handlers.CarsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class CarsServiceImpl implements CarsService {

    private final CarsRepository repository;

    @Autowired
    public CarsServiceImpl(CarsRepository repository) {
        this.repository = repository;
    }


    // Get all cars

    public List<Cars> getAll() {
        List<Cars> carsList = repository.findAll();
        return carsList;
    }

    // Get by id
    public Cars getById(Long id) {
        Optional<Cars> rentCars = repository.findById(id);
        if (rentCars.isPresent()) {
            Cars existingCars = rentCars.get();
            return existingCars;
        } else {
            throw new CarsNotFoundException(id);
        }
    }

    // Add new part
    public void saveRentCarsToDb(MultipartFile file, String brand,String model, String vin,String plateNum,String gearbox, Integer buyPrice, Integer rentPrice,String description,Integer year,Boolean availability) {
        Optional<Cars> optionalRentCars = repository.findByPlateNum(plateNum);
        if (optionalRentCars.isPresent()) {
            throw new RuntimeException();
        } else {
            Cars newCars = new Cars();
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("not a valid file");
            }
            try {
                newCars.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            newCars.setBrand(brand);
            newCars.setModel(model);
            newCars.setVin(vin);
            newCars.setPlateNum(plateNum);
            newCars.setGearbox(gearbox);
            newCars.setBuyPrice(buyPrice);
            newCars.setRentPrice(rentPrice);
            newCars.setDescription(description);
            newCars.setYear(year);
            newCars.setAvailability(availability);

            repository.save(newCars);
        }
    }

    // Delete

    public void deleteById(Long id) {
        Optional<Cars> optionalRentCars = repository.findById(id);
        if (optionalRentCars.isPresent()) {
            Cars existingVehicle = optionalRentCars.get();
            repository.deleteById(existingVehicle.getId());
        } else {
            throw new CarsNotFoundException(id);
        }
    }

    // Update

    public void updateRentCars(Long id, Cars cars) {
        Optional<Cars> optionalRentCars = repository.findById(id);
        if (optionalRentCars.isPresent()) {
            Cars existingCars = optionalRentCars.get();

            // Update only if the value in cars is not null or false for boolean values
            if (cars.getBrand() != null) {
                existingCars.setBrand(cars.getBrand());
            }
            if (cars.getModel() != null) {
                existingCars.setModel(cars.getModel());
            }
            if (cars.getVin() != null) {
                existingCars.setVin(cars.getVin());
            }
            if (cars.getPlateNum() != null) {
                existingCars.setPlateNum(cars.getPlateNum());
            }
            if (cars.getGearbox() != null) {
                existingCars.setGearbox(cars.getGearbox());
            }
            if (cars.getBuyPrice() != null) {
                existingCars.setBuyPrice(cars.getBuyPrice());
            }
            if (cars.getRentPrice() != null) {
                existingCars.setRentPrice(cars.getRentPrice());
            }
            if (cars.getDescription() != null) {
                existingCars.setDescription(cars.getDescription());
            }
            if (cars.isAvailability() != false) {
                existingCars.setAvailability(true);
            }

            repository.save(existingCars);
        } else {
            throw new CarsNotFoundException(id);
        }
    }





















}
