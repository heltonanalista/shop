package com.bike.shop.dto;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.ClientModel;
import com.bike.shop.model.PayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeShopDto {

    private Long id;
    private LocalDateTime shopData;
    private Long client_id;
    private List<Long> bike_id;
    private PayType payType;

}
