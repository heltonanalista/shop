package com.bike.shop.controller;

import com.bike.shop.dto.BikeModelDto;
import com.bike.shop.dto.BikeShopDto;
import com.bike.shop.model.BikeShopModel;
import com.bike.shop.repository.BikeShopRepository;
import com.bike.shop.service.BikeShopService;
import com.bike.shop.service.ConvertBikeShopService;
import jakarta.validation.Valid;
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
@RequestMapping("bikeshop")
public class BikeShopController {
private BikeShopModel bikeShopModel;
@Autowired
private BikeShopService bikeShopService;
@Autowired
public ConvertBikeShopService convertBikeShopService;
    @PostMapping("create")
    public ResponseEntity<?> register(@RequestBody  BikeShopDto bikeShopDto) {

        try {

            bikeShopModel = bikeShopService.saveBikeShop(convertBikeShopService.entity(bikeShopDto));
            log.info("BIKE-CONTROLLER = bike registrada");
        } catch (Exception e) {
            log.info("BIKE-CONTROLLER = erro ao registrar bike");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CAMPO NAO PODE SER VAZIO OU NULO");

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(bikeShopModel);
    }
}
