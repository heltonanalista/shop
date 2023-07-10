package com.bike.shop.dto;
import com.bike.shop.model.BikeModel;
import com.bike.shop.model.ClientModel;
import com.bike.shop.model.bikeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeOrderDto {
    private LocalDateTime shopData;
    private ClientModel clientModel;
    private BikeModel bikeModel;
    private Double totalPrice;

}
