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
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceOrderDto {
    private Double laborCost;
    private BikeModel bikeModel;
    private LocalDateTime shopDate;
    private ClientModel clientModel;
    private Double totalPrice;
    private List<PartsModel> partsModel;

}
