package com.bike.shop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "manutencao")
public class MaintenanceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @OneToOne
    @JoinColumn(name = "bike_id")
    private BikeModel bikeModel;
    private String type;
    private String description;
    @OneToMany
    @JoinTable(name = "peca_reposicao",joinColumns = @JoinColumn(name = "manutencao_id"),inverseJoinColumns = @JoinColumn(name = "peca_id"))
    private List<PartsModel> partsExchange;

    private Double price;

    public MaintenanceModel(Long id, LocalDateTime date, BikeModel bikeModel, String type, String description, List<PartsModel> partsExchange, Double price) {
        this.id = id;
        this.date = date;
        this.bikeModel = bikeModel;
        this.type = type;
        this.description = description;
        this.partsExchange = partsExchange;

    }

    public MaintenanceModel() {
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
