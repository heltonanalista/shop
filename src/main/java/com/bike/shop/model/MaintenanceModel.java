package com.bike.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import jakarta.persistence.JoinTable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientModel clientModel;
    private String description;
    @OneToMany
    @JoinTable(name = "peca_reposicao", joinColumns = @JoinColumn(name = "manutencao_id"), inverseJoinColumns = @JoinColumn(name = "peca_id"))
    private List<PartsModel> partsExchange;
    private Double laborCost;
    private Double totalPrice;
}
