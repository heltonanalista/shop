package com.bike.shop.service;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.BikeOrder;
import com.bike.shop.model.MaintenanceOrder;
import com.bike.shop.repository.BikeOrderRepository;
import com.bike.shop.repository.BikeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeOrderService {
    @Autowired
    private BikeOrderRepository bikeOrderRepository;
    private Double valortotal = 0.0;
    private List<BikeModel> bikeModel;
    public BikeOrder saveBikeOrder(BikeOrder bikeOrder) {
       // valortotal = bikeOrder.getBikeModel().stream().mapToDouble((price) -> price.getPrice()).sum();
        bikeOrder.setTotalPrice(valortotal);
        return bikeOrderRepository.save(bikeOrder);
    }
    public List<BikeOrder> all(){
        return bikeOrderRepository.findAll();
    }
}