package com.phegondev.usersmanagementsystem.admin.muscleparts;

import com.phegondev.usersmanagementsystem.handlers.RentCarsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class RentCarsServiceImpl implements RentCarsService {

    private final RentCarsRepository repository;

    @Autowired
    public RentCarsServiceImpl(RentCarsRepository repository) {
        this.repository = repository;
    }


    // Get all muscle parts

    public List<RentCars> getAll() {
        List<RentCars> rentCarsList = repository.findAll();
        return rentCarsList;
    }

    // Get by id
    public RentCars getById(Long id) {
        Optional<RentCars> rentCars = repository.findById(id);
        if (rentCars.isPresent()) {
            RentCars existingRentCars = rentCars.get();
            return existingRentCars;
        } else {
            throw new RentCarsNotFoundException(id);
        }
    }

    // Add new muscle part
    public void saveRentCarsToDb(MultipartFile file, String brand,String model, String vin,String plateNum,String gearbox, Integer buyPrice, Integer rentPrice,String description,Integer year,Boolean availability) {
        Optional<RentCars> optionalRentCars = repository.findByPlateNum(plateNum);
        if (optionalRentCars.isPresent()) {
            throw new RuntimeException();
        } else {
            RentCars newRentCars = new RentCars();
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("not a valid file");
            }
            try {
                newRentCars.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            newRentCars.setBrand(brand);
            newRentCars.setModel(model);
            newRentCars.setVin(vin);
            newRentCars.setPlateNum(plateNum);
            newRentCars.setGearbox(gearbox);
            newRentCars.setBuyPrice(buyPrice);
            newRentCars.setRentPrice(rentPrice);
            newRentCars.setDescription(description);
            newRentCars.setYear(year);
            newRentCars.setAvailability(availability);

            repository.save(newRentCars);
        }
    }

    // Delete

    public void deleteById(Long id) {
        Optional<RentCars> optionalRentCars = repository.findById(id);
        if (optionalRentCars.isPresent()) {
            RentCars existingVehicle = optionalRentCars.get();
            repository.deleteById(existingVehicle.getId());
        } else {
            throw new RentCarsNotFoundException(id);
        }
    }

    // Update

    public void updateRentCars(Long id, RentCars rentCars) {
        Optional<RentCars> optionalRentCars = repository.findById(id);
        if (optionalRentCars.isPresent()) {
            RentCars existingRentCars = optionalRentCars.get();

            // Update only if the value in rentCars is not null or false for boolean values
            if (rentCars.getBrand() != null) {
                existingRentCars.setBrand(rentCars.getBrand());
            }
            if (rentCars.getModel() != null) {
                existingRentCars.setModel(rentCars.getModel());
            }
            if (rentCars.getVin() != null) {
                existingRentCars.setVin(rentCars.getVin());
            }
            if (rentCars.getPlateNum() != null) {
                existingRentCars.setPlateNum(rentCars.getPlateNum());
            }
            if (rentCars.getGearbox() != null) {
                existingRentCars.setGearbox(rentCars.getGearbox());
            }
            if (rentCars.getBuyPrice() != null) {
                existingRentCars.setBuyPrice(rentCars.getBuyPrice());
            }
            if (rentCars.getRentPrice() != null) {
                existingRentCars.setRentPrice(rentCars.getRentPrice());
            }
            if (rentCars.getDescription() != null) {
                existingRentCars.setDescription(rentCars.getDescription());
            }
            if (rentCars.isAvailability() != false) {
                existingRentCars.setAvailability(true);
            }

            repository.save(existingRentCars);
        } else {
            throw new RentCarsNotFoundException(id);
        }
    }





















}
