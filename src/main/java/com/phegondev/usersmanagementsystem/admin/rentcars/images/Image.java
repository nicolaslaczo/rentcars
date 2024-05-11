package com.phegondev.usersmanagementsystem.admin.rentcars.images;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phegondev.usersmanagementsystem.admin.rentcars.rentcars.Cars;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "image_generator")
    private Long id;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "car_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Cars cars;























}
