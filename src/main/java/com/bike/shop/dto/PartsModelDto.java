package com.bike.shop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PartsModelDto {
    private String name;
    private String brand;
    private String model;
    private Integer quantity;
    private Double price;
}
