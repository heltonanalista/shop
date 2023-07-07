package com.bike.shop.controller;

import com.bike.shop.dto.BikeShopDto;
import com.bike.shop.model.BikeShopModel;
import com.bike.shop.service.BikeShopService;
import com.bike.shop.service.ConvertBikeShopService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/bikeshop")
public class BikeShopController {
private BikeShopModel bikeShopModel;
@Autowired
private BikeShopService bikeShopService;
@Autowired
public ConvertBikeShopService convertBikeShopService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody BikeShopDto bikeShopDto) {

        bikeShopModel = bikeShopService.saveBikeShop(convertBikeShopService.bikeShopEntity(bikeShopDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(bikeShopModel);
    }
//        log.info("bikeshop controller valor {}"+bikeShopDto);
//        try {
//
//            bikeShopModel = bikeShopService.saveBikeShop(convertBikeShopService.bikeShopEntity(bikeShopDto));
//            log.info("bikeshop controller valor {}"+bikeShopModel);
//        } catch (Exception e) {
//            log.info("bikeshop-CONTROLLER = exception {}"+e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CAMPO NAO PODE SER VAZIO OU NULO");
//
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(bikeShopModel);
//    }
}
