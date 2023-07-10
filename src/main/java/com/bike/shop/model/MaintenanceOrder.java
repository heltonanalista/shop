package com.bike.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MaintenanceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double laborCost;
 @OneToOne
    private BikeModel bikeModel;
    private LocalDateTime shopDate;
    @OneToOne
    private ClientModel clientModel;
    private Double totalPrice;
}
