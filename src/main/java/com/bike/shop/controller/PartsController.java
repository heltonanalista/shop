package com.bike.shop.controller;


import com.bike.shop.PartsFeign;
import com.bike.shop.dto.BikeModelDto;
import com.bike.shop.dto.PartsModelDto;
import com.bike.shop.model.PartsModel;
import com.bike.shop.service.ConvertPartsService;
import com.bike.shop.service.PartsService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("parts")
public class PartsController {
    @Autowired
    public PartsFeign partsFeign;
    @Autowired
    public PartsService partsService;
    @Autowired
    public ConvertPartsService convertPartsService;
    List<PartsModel> pecaModel;
    public PartsModel partsModel;

    @GetMapping("listar")
    public List<PartsModel> listParts() {


        pecaModel = partsFeign.listParts();


        return pecaModel;

    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid PartsModelDto partsModelDto) {
            try {

            partsModel = partsService.saveParts(convertPartsService.partsEntity(partsModelDto));
            System.out.println(partsModel);
            log.info("BIKE-CONTROLLER = bike registrada");
        } catch (Exception e) {
            log.info("BIKE-CONTROLLER = erro ao registrar bike");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CAMPO NAO PODE SER VAZIO OU NULO");

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(convertPartsService.partsDto(partsModel));
    }
}

