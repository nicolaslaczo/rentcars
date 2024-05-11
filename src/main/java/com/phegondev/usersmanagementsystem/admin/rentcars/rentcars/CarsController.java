package com.phegondev.usersmanagementsystem.admin.rentcars.rentcars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class CarsController {

    @Autowired
    private CarsService service;


    @GetMapping("/admin/rent")
    public ResponseEntity<List<Cars>> getAll() {
        List<Cars> partList = service.getAll();
        return ResponseEntity.ok().body(partList);
    }

    @GetMapping("/admin/rent/{vehicleId}")
    public ResponseEntity<Cars> getRentCarsById(@PathVariable Long vehicleId) {
        Cars cars = service.getById(vehicleId);
        return ResponseEntity.ok().body(cars);
    }


    @PostMapping("/admin/rent")
    public ResponseEntity<HttpStatus> addNewMuscleParts(@RequestParam("file")MultipartFile file,
                                                        @RequestParam String brand,
                                                        @RequestParam String model,
                                                        @RequestParam String vin,
                                                        @RequestParam String plateNum,
                                                        @RequestParam Integer year,
                                                        @RequestParam Integer buyPrice,
                                                        @RequestParam Integer rentPrice,
                                                        @RequestParam String gearbox,
                                                        @RequestParam Boolean availability,
                                                        @RequestParam String description
                                                        ) {
        service.saveRentCarsToDb(file,brand,model,vin,plateNum,gearbox,buyPrice,rentPrice,description,year,availability);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/admin/rent/{vehicleId}")
    public ResponseEntity<HttpStatus> deleteVehicleById(@PathVariable Long vehicleId) {
        service.deleteById(vehicleId);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/admin/rent/{vehicleId}")
    public ResponseEntity<HttpStatus> updateVehicle(@PathVariable Long vehicleId,@RequestBody Cars cars) {
        service.updateRentCars(vehicleId, cars);
        return ResponseEntity.ok().build();
    }
























}
