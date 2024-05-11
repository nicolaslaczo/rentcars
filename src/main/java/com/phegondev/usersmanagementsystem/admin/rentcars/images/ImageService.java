package com.phegondev.usersmanagementsystem.admin.rentcars.images;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    void addImageToCar(Long carId, MultipartFile file);


    List<Image> getImagesByCarId(Long carId);

    void deleteImageByCarId(Long carId,Long imageId);
}
