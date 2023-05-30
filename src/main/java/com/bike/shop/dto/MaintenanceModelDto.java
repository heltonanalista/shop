package com.bike.shop.dto;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.ClientModel;
import com.bike.shop.model.PartsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceModelDto {
    private Long id;
    private LocalDateTime date;
    private BikeModel bikeModel;
    private ClientModel clientModel;
    private String description;
    private List<PartsModel> partsExchange;
    private Double laborCost;
    private Double totalPrice;


}
