package com.bike.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "compra_bike")
public class BikeShopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime shopData;
    @OneToOne
    private ClientModel clientModel;
    @ManyToMany
    private List<BikeModel>bikeModel;
    private Double totalPrice;
    }

