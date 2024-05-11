package com.phegondev.usersmanagementsystem.admin.rentcars.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RentOrderController {
    @Autowired
    private RentOrderService orderService;

    @GetMapping("/admin/orders")
    public ResponseEntity<List<RentOrderDto>> getAllOrders() {
        List<RentOrderDto> orderList = orderService.getAllOrdersWithDetails();
        return ResponseEntity.ok().body(orderList);
    }
}
