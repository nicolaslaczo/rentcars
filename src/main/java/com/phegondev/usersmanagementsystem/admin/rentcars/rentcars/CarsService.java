package com.phegondev.usersmanagementsystem.admin.rentcars.rentcars;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarsService {

     List<Cars> getAll();

    Cars getById(Long id);

    void saveRentCarsToDb(MultipartFile file, String brand,String model, String vin,String plateNum,String gearbox, Integer buyPrice, Integer rentPrice,String description,Integer year,Boolean availability);

    void deleteById(Long id);

    void updateRentCars(Long id, Cars cars);
}
