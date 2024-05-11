package com.phegondev.usersmanagementsystem.admin.rentcars.rentcars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Cars,Long> {

    Optional<Cars> findByPlateNum(String plateNum);
}
