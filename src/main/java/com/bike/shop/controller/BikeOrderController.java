package com.bike.shop.controller;

import com.bike.shop.dto.BikeOrderDto;
import com.bike.shop.model.BikeOrder;
import com.bike.shop.model.MaintenanceOrder;
import com.bike.shop.service.BikeOrderService;
import com.bike.shop.service.ConvertBikeOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/bikeorder")
public class BikeOrderController {
private BikeOrder bikeOrder;
@Autowired
private BikeOrderService bikeOrderService;
@Autowired
public ConvertBikeOrderService convertBikeOrderService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody BikeOrderDto bikeOrderDto) {

        bikeOrder = bikeOrderService.saveBikeOrder(convertBikeOrderService.bikeShopEntity(bikeOrderDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(bikeOrder);
    }
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<BikeOrder> cod;
        try {
            cod = bikeOrderService.all();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("MANUTENCAO NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cod);
    }
}
