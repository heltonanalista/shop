package com.bike.shop.dto;

import com.bike.shop.model.PartsModel;

public class PartsModelDto {

    private Long id;
    private SupplierModel supplier;
    private String name;

    private String brand;

    private String model;

    private Integer quantity;

    private Double price;

    public PartsModelDto(Long id, SupplierModel supplier, String name, String brand, String model, Integer quantity, Double price) {
        this.id = id;
        this.supplier = supplier;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
        this.price = price;
    }

    public PartsModelDto(PartsModel partsModel) {
        this.id=partsModel.getId();
        this.supplier=partsModel.getSupplier();
        this.name = partsModel.getName();
        this.brand = partsModel.getBrand();
        this.model = partsModel.getModel();
        this.quantity = partsModel.getQuantity();
        this.price = getPrice();




    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public SupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
    }

    public PartsModelDto() {
    }
}
