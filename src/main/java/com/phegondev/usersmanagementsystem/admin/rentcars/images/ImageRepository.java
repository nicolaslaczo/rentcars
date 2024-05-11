package com.phegondev.usersmanagementsystem.admin.rentcars.images;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByCarsId(Long carId);
    @Transactional
    void deleteByCarsIdAndId(Long rentCarsId, Long id);




}
