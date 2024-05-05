package com.phegondev.usersmanagementsystem.admin.muscleparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RentCarsController {

    @Autowired
    private RentCarsService service;


    @GetMapping("/admin/rent")
    public ResponseEntity<List<RentCars>> getAll() {
        List<RentCars> partList = service.getAll();
        return ResponseEntity.ok().body(partList);
    }

    @GetMapping("/admin/rent/{vehicleId}")
    public ResponseEntity<RentCars> getRentCarsById(@PathVariable Long vehicleId) {
        RentCars rentCars = service.getById(vehicleId);
        return ResponseEntity.ok().body(rentCars);
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
    public ResponseEntity<HttpStatus> updateVehicle(@PathVariable Long vehicleId,@RequestBody RentCars rentCars) {
        service.updateRentCars(vehicleId,rentCars);
        return ResponseEntity.ok().build();
    }
























}
