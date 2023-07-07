package com.bike.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
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

