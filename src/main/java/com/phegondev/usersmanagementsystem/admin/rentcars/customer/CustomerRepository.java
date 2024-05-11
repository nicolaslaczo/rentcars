package com.phegondev.usersmanagementsystem.admin.rentcars.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    // Admin only //

    boolean existsByEmail(String email);

    Customer findByEmail(String email);
}
