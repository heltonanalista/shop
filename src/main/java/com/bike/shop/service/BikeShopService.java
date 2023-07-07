package com.bike.shop.service;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.BikeShopModel;
import com.bike.shop.repository.BikeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeShopService {
    @Autowired
    private BikeShopRepository bikeShopRepository;
    private Double valortotal = 0.0;
    private List<BikeModel> bikeModel;

    public BikeShopModel saveBikeShop(BikeShopModel bikeShopModel) {
        valortotal = bikeShopModel.getBikeModel().stream().mapToDouble((price) -> price.getPrice()).sum();


        bikeShopModel.setTotalPrice(valortotal);
        return bikeShopRepository.save(bikeShopModel);
    }
}