package com.phegondev.usersmanagementsystem.admin.rentcars.rent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phegondev.usersmanagementsystem.admin.rentcars.customer.Customer;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.Cars;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "car_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cars cars;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "customer_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;



}
