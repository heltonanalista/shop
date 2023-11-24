package com.bike.shop.controller;

import com.bike.shop.dto.BikeOrderDto;
import com.bike.shop.dto.MaintenanceOrderDto;
import com.bike.shop.model.BikeOrder;
import com.bike.shop.model.MaintenanceModel;
import com.bike.shop.model.MaintenanceOrder;
import com.bike.shop.service.BikeOrderService;
import com.bike.shop.service.ConvertBikeOrderService;
import com.bike.shop.service.ConvertMaintenanceOrderService;
import com.bike.shop.service.MaintenanceOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/maintenanceorder")
public class MaintenanceOrderController {
    private BikeOrder bikeOrder;
    @Autowired
    private ConvertMaintenanceOrderService convertMaintenanceOrderService;
    private MaintenanceOrder maintenanceOrder;
    @Autowired
    private MaintenanceOrderService maintenanceOrderService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MaintenanceOrderDto maintenanceOrderDto) {

        maintenanceOrder = maintenanceOrderService.saveMaintenanceOrder(convertMaintenanceOrderService
                .maintenanceOrderEntity(maintenanceOrderDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(bikeOrder);
    }
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<MaintenanceOrder> cod;
        try {
            cod = maintenanceOrderService.all();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("MANUTENCAO NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cod);
    }
}