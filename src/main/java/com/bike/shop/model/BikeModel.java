package com.bike.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Data
@Entity
@Table(name = "bike")
public class BikeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "brand")
    private String brand;

    @NotBlank
    @Column(name = "model")
    private String model;
    @NotBlank
    @Column(name = "year")
    private String year;
    @NotBlank
    @Column(name = "color")
    private String color;
    @NotNull
    @Column(name = "price")
    private Double price;
    @Enumerated(EnumType.STRING)
    private bikeType bikeType;


}
