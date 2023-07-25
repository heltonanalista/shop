package com.bike.shop.dto;
import com.bike.shop.model.BikeModel;
import com.bike.shop.model.ClientModel;
import com.bike.shop.model.bikeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeOrderDto {
    @NotNull
    private LocalDateTime shopData;
    @NotNull
    private ClientModel clientModel;
    @NotNull
    private BikeModel bikeModel;
    @NotNull
    private Double totalPrice;

}
