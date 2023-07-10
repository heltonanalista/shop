package com.bike.shop.dto;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.ClientModel;
import com.bike.shop.model.PartsModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    private LocalDateTime date;
    @NotBlank
    private BikeModel bikeModel;
    @NotBlank
    private ClientModel clientModel;
    @NotBlank
    private String description;
    @NotBlank
    private List<PartsModel> partsExchange;
    @NotNull
    private Double laborCost;
    @NotNull
    private Double totalPrice;
}
