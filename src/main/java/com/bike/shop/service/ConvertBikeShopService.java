package com.bike.shop.service;

import com.bike.shop.dto.BikeShopDto;
import com.bike.shop.model.BikeModel;
import com.bike.shop.model.BikeShopModel;
import com.bike.shop.model.ClientModel;
import com.bike.shop.repository.BikeRepository;
import com.bike.shop.repository.ClientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Log4j2
public class  ConvertBikeShopService {

    private BikeShopModel bikeShopModel;
    private ClientModel clientModel;
    private List<BikeModel> bikeModelList;
    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    public BikeRepository bikeRepository;

    public BikeShopModel entity(BikeShopDto bikeShopDto) {
        bikeShopModel=new BikeShopModel();
        bikeShopModel.setShopData(bikeShopDto.getShopData());
        clientModel = clientRepository.findById(bikeShopDto.getClient_id()).get();
        bikeModelList = bikeRepository.findAllById(bikeShopDto.getBike_id());
        bikeShopModel.setClientModel(clientModel);
        bikeShopModel.setBikeModel(bikeModelList);
       log.info("CONVERT BIKE SHOP SERVICE ");
        return bikeShopModel;

    }
}