package com.bike.shop.dto;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.PartsModel;

import java.time.LocalDateTime;
import java.util.List;

public class MaintenanceModelDto {
    private Long id;
    private LocalDateTime date;
    private BikeModel bikeModel;
    private String type;
    private String description;
    private List<PartsModel> partsExchange;


    public MaintenanceModelDto(Long id, LocalDateTime date, BikeModel bikeModel, String type, String description, List<PartsModel> partsExchange) {
        this.id = id;
        this.bikeModel = bikeModel;
        this.type = type;
        this.description = description;
        this.partsExchange = partsExchange;

    }

    public MaintenanceModelDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BikeModel getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(BikeModel bikeModel) {
        this.bikeModel = bikeModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PartsModel> getPartsExchange() {
        return partsExchange;
    }

    public void setPartsExchange(List<PartsModel> partsExchange) {
        this.partsExchange = partsExchange;
    }


}
