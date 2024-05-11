package com.phegondev.usersmanagementsystem.admin.rentcars.rent;

import java.util.List;

public interface RentOrderService {

    // ------------- ADMIN --------------- //

    List<RentOrderDto> getAllOrdersWithDetails();
}
