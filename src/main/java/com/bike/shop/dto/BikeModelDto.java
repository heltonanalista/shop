package com.bike.shop.dto;
import com.bike.shop.model.BikeModel;
import com.bike.shop.model.bikeType;
public class BikeModelDto {
    private String brand;
    private String model;
    private String year;
    private String color;
    private Double price;
    private bikeType bikeType;
    public BikeModelDto(BikeModel bikeModel) {
    this.brand=bikeModel.getBrand();
    this.model= bikeModel.getModel();
    this.year= bikeModel.getYear();
    this.color=bikeModel.getColor();
    this.price= bikeModel.getPrice();
    this.bikeType=bikeModel.getBikeType();
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
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public bikeType getBikeType() {
        return bikeType;
    }
    public void setBikeType(bikeType bikeType) {
        this.bikeType = bikeType;
    }
    public BikeModelDto(String brand, String model, String year, String color, Double price, com.bike.shop.model.bikeType bikeType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.bikeType = bikeType;
    }

    public BikeModelDto() {
    }
}
