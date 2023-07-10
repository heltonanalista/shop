package com.bike.shop.dto;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOrderDto {
    private Double laborCost;
    private BikeModel bikeModel;
    private LocalDateTime shopDate;
    private ClientModel clientModel;
    private Double totalPrice;

}
