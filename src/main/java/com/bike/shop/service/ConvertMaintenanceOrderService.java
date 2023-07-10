package com.bike.shop.service;

import com.bike.shop.dto.BikeOrderDto;
import com.bike.shop.dto.MaintenanceOrderDto;
import com.bike.shop.model.BikeModel;
import com.bike.shop.model.BikeOrder;
import com.bike.shop.model.ClientModel;
import com.bike.shop.model.MaintenanceOrder;
import com.bike.shop.repository.BikeRepository;
import com.bike.shop.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ConvertMaintenanceOrderService {
   private MaintenanceOrder maintenanceOrder;
    private MaintenanceOrderDto maintenanceOrderDto;

    public MaintenanceOrderDto maintenanceOrderDto(MaintenanceOrder maintenanceOrder) {
        maintenanceOrderDto = new MaintenanceOrderDto();
        BeanUtils.copyProperties(maintenanceOrder, maintenanceOrderDto);
        return maintenanceOrderDto;
    }
    public MaintenanceOrder maintenanceOrderEntity(MaintenanceOrderDto maintenanceOrderDto) {
        maintenanceOrder= new MaintenanceOrder();
        BeanUtils.copyProperties(maintenanceOrderDto, maintenanceOrder);
        return maintenanceOrder;
    }
}
