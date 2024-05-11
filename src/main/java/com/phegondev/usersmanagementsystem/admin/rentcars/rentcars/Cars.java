package com.phegondev.usersmanagementsystem.admin.rentcars.rentcars;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String vin;
    private String plateNum;
    private Integer year;
    private Integer buyPrice;
    private Integer rentPrice;
    private String gearbox;
    private boolean availability;
    @Column(columnDefinition = "text")
    private String description;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;




    private Cars(Builder builder) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.vin = builder.vin;
        this.plateNum = builder.plateNum;
        this.year = builder.year;
        this.buyPrice = builder.buyPrice;
        this.rentPrice = builder.rentPrice;
        this.gearbox = builder.gearbox;
        this.availability = builder.availability;;
        this.description = builder.description;
        this.image = builder.image;
    }

    public static class Builder {
        private Long id;
        private String brand;
        private String model;
        private String plateNum;
        private Integer year;
        private String vin;
        private Integer buyPrice;
        private Integer rentPrice;
        private String gearbox;
        private boolean availability;
        private String description;
        private String image;






        public Builder(Long id, String brand, String model) {
            this.id = id;
            this.brand = brand;
            this.model = model;
        }

        public Builder plateNum(String plateNum) {
            this.plateNum = plateNum;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Builder vin(String vin) {
            this.vin = vin;
            return this;
        }

        public Builder buyPrice(Integer buyPrice) {
            this.buyPrice = buyPrice;
            return this;
        }

        public Builder rentPrice(Integer rentPrice) {
            this.rentPrice = rentPrice;
            return this;
        }

        public Builder gearbox(String gearbox) {
            this.gearbox = gearbox;
            return this;
        }

        public Builder availability(boolean availability) {
            this.availability = availability;
            return this;
        }

        private Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }




        public Cars build() {
            return new Cars(this);
        }
    }
}





