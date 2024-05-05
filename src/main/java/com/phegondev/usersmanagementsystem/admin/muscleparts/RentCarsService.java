package com.phegondev.usersmanagementsystem.admin.muscleparts;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface RentCarsService {

     List<RentCars> getAll();

    RentCars getById(Long id);

    void saveRentCarsToDb(MultipartFile file, String brand,String model, String vin,String plateNum,String gearbox, Integer buyPrice, Integer rentPrice,String description,Integer year,Boolean availability);

    void deleteById(Long id);

    void updateRentCars(Long id,RentCars rentCars);
}
