package com.bike.shop.dto;

import com.bike.shop.model.bikeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeModelDto {
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String year;
    @NotBlank
    private String color;
    @NotNull
    private Double price;
    //  @Enumerated(EnumType.STRING)
    @NotNull
    private com.bike.shop.model.bikeType bikeType;

}
