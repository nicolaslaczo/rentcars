package com.phegondev.usersmanagementsystem.admin.rentcars.rent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phegondev.usersmanagementsystem.admin.rentcars.customer.Customer;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.Cars;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "card_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cars cars;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "customer_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;



}
