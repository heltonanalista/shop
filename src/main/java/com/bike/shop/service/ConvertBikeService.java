package com.bike.shop.service;

import com.bike.shop.dto.BikeOrderDto;
import com.bike.shop.model.BikeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConvertBikeService {
    private BikeModel bikeModel;
    private BikeOrderDto bikeOrderDto;
    public BikeOrderDto bikeDto(BikeModel bikeModel) {
        this.bikeOrderDto = new BikeOrderDto();
        BeanUtils.copyProperties(bikeModel, bikeOrderDto);
        return this.bikeOrderDto;
    }
    public BikeModel bikeEntity(BikeOrderDto bikeOrderDto) {
        bikeModel = new BikeModel();
        BeanUtils.copyProperties(bikeOrderDto,bikeModel);
        return this.bikeModel;
    }
}
