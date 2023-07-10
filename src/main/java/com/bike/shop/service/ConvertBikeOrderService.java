package com.bike.shop.service;

import com.bike.shop.dto.BikeOrderDto;
import com.bike.shop.model.BikeModel;
import com.bike.shop.model.BikeOrder;
import com.bike.shop.model.ClientModel;
import com.bike.shop.repository.BikeRepository;
import com.bike.shop.repository.ClientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class ConvertBikeOrderService {
   private BikeOrder bikeOrder;
    private BikeOrderDto bikeOrderDto;
    private ClientModel clientModel;
    private List<BikeModel> bikeModelList;
    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    public BikeRepository bikeRepository;

    public BikeOrderDto bikeShopDto(BikeOrder bikeOrder) {
        bikeOrderDto = new BikeOrderDto();
        BeanUtils.copyProperties(bikeOrder, bikeOrderDto);
        return bikeOrderDto;
    }
    public BikeOrder bikeShopEntity(BikeOrderDto bikeOrderDto) {
        bikeOrder = new BikeOrder();
        BeanUtils.copyProperties(bikeOrderDto, bikeOrder);
        return bikeOrder;
    }
}