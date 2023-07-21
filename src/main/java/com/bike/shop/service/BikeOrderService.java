package com.bike.shop.service;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.BikeOrder;
import com.bike.shop.model.MaintenanceOrder;
import com.bike.shop.model.PartsModel;
import com.bike.shop.repository.BikeOrderRepository;
import com.bike.shop.repository.BikeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeOrderService {
    @Autowired
    private BikeOrderRepository bikeOrderRepository;
    @Autowired
    private BikeService bikeService;
    private Double valortotal = 0.0;
    private List<BikeModel> bikeModel;
    public BikeOrder saveBikeOrder(BikeOrder bikeOrder) {
        BikeModel bike = bikeService.findBikeId(bikeOrder.getId());
            bikeOrder.setTotalPrice(bike.getPrice());
        return bikeOrderRepository.save(bikeOrder);
    }
    public List<BikeOrder> all(){
        return bikeOrderRepository.findAll();
    }


}