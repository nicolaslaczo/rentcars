package com.phegondev.usersmanagementsystem.admin.rentcars.images;

import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.Cars;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.CarsRepository;
import com.phegondev.usersmanagementsystem.handlers.CarsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CarsRepository carsRepository;


    // Add image to car

    public void addImageToCar(Long carId, MultipartFile file) {
        Cars cars = carsRepository.findById(carId).orElseThrow(() -> new CarsNotFoundException(carId));
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            Image newImage = new Image();
            newImage.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            newImage.setCars(cars);
            imageRepository.save(newImage);
        } catch (IOException e ){
            e.printStackTrace();
        }
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


    // Delete image by car id and image id

    public void deleteImageByCarId(Long carId,Long imageId) {
        imageRepository.deleteByCarsIdAndId(carId,imageId);
    }






















}
