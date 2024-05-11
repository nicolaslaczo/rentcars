package com.phegondev.usersmanagementsystem.admin.rentcars.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;


    @PostMapping("/admin/rent/{carId}/image")
    public ResponseEntity<HttpStatus> addImageToCar(@PathVariable Long carId,@RequestParam MultipartFile file) {
        imageService.addImageToCar(carId,file);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/admin/rent/{carId}/image")
    public ResponseEntity<List<Image>> getImagesForCarId(@PathVariable Long carId) {
        List<Image> imageList = imageService.getImagesByCarId(carId);
        return ResponseEntity.ok().body(imageList);
    }





    @DeleteMapping("/admin/rent/{carId}/image/{imageId}")
    public ResponseEntity<HttpStatus>deleteImageByCarAndImageId(@PathVariable Long carId,@PathVariable Long imageId) {
        imageService.deleteImageByCarId(carId,imageId);
        return ResponseEntity.ok().build();
    }




}
