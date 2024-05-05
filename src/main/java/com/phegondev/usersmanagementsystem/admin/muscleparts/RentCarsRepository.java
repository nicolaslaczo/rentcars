package com.phegondev.usersmanagementsystem.admin.muscleparts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentCarsRepository extends JpaRepository<RentCars,Long> {

    Optional<RentCars> findByPlateNum(String plateNum);
}
