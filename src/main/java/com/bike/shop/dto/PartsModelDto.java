package com.bike.shop.dto;


import com.bike.shop.model.PartsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PartsModelDto {

    private String name;
    private String brand;
    private String model;
    private Integer quantity;
    private Double price;

    public PartsModelDto(PartsModel partsModel) {
        this.name = partsModel.getName();
        this.brand = partsModel.getBrand();
        this.model = partsModel.getModel();
        this.quantity = partsModel.getQuantity();
        this.price = partsModel.getPrice();
    }

    public PartsModelDto(String name, String brand, String model, Integer quantity, Double price) {

        this.name = name;
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
        this.price = price;
    }

    public PartsModelDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
