package com.bike.shop.dto;
import com.bike.shop.model.bikeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeModelDto {
    private Long id;
    private String brand;
    private String model;
    private String year;
    private String color;
    private Double price;
    private bikeType bikeType;

}
