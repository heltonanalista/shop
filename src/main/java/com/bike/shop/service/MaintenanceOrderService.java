package com.bike.shop.service;

import com.bike.shop.model.*;
import com.bike.shop.repository.BikeOrderRepository;
import com.bike.shop.repository.MaintenanceOrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Log4j2
@Service
public class MaintenanceOrderService {
    @Autowired
    private MaintenanceOrderRepository maintenanceOrderRepository;
    @Autowired
    private PartsService partsService;
    public MaintenanceOrder saveMaintenanceOrder(MaintenanceOrder maintenanceOrder) {
        log.info("salvar pedido manutencao{}" + maintenanceOrder);
        maintenanceOrder.setTotalPrice(maintenanceOrder.getLaborCost() + sumTotal(maintenanceOrder));
        System.out.println(maintenanceOrder.getTotalPrice());
        return maintenanceOrderRepository.save(maintenanceOrder);
    }
    public List<MaintenanceOrder> all() {
        return maintenanceOrderRepository.findAll();
    }
    private Double sumTotal(MaintenanceOrder maintenanceOrder) {
        log.info("salvar pedido manutencao{}" + maintenanceOrder.getPartsModel().get(0).getPrice());
        List<Long> partid = maintenanceOrder.getPartsModel().stream().map(x -> x.getId()).collect(Collectors.toList());
        List<PartsModel> listParts = partsService.allId(partid);
        return listParts.stream().mapToDouble(part -> part.getPrice()).sum();
    }


}
