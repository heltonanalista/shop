package com.bike.shop.service;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.BikeOrder;
import com.bike.shop.model.MaintenanceModel;
import com.bike.shop.model.MaintenanceOrder;
import com.bike.shop.repository.BikeOrderRepository;
import com.bike.shop.repository.MaintenanceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaintenanceOrderService {
    @Autowired
   private MaintenanceOrderRepository maintenanceOrderRepository;

       public MaintenanceOrder saveMaintenanceOrder(MaintenanceOrder maintenanceOrder) {

        return maintenanceOrderRepository.save(maintenanceOrder);
    }
    public List<MaintenanceOrder> all(){
        return maintenanceOrderRepository.findAll();
    }
}
