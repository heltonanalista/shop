package com.bike.shop.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartsModelDto {
    @NotBlank
    private String name;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotNull
    private Integer quantity;
    @NotNull
    private Double price;
}
