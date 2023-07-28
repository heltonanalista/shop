package com.bike.shop.controller;


import com.bike.shop.dto.PartsModelDto;
import com.bike.shop.model.PartsModel;
import com.bike.shop.service.ConvertPartsService;
import com.bike.shop.service.PartsFeign;
import com.bike.shop.service.PartsService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    @PostMapping("/register")
    public ResponseEntity<PartsModelDto> register(@RequestBody @Valid PartsModelDto partsModelDto) {
        System.out.println(partsModelDto.getModel());
            partsModel = partsService.saveParts(convertPartsService.partsEntity(partsModelDto));
          return ResponseEntity.status(HttpStatus.CREATED).body(convertPartsService.partsDto(partsModel));
    }
    @GetMapping("/findid/{id}")
    public ResponseEntity<PartsModelDto> find(@PathVariable Long id) {
        PartsModel cod;
            cod = partsService.findPartsId(id);
          return ResponseEntity.status(HttpStatus.OK).body(convertPartsService.partsDto(cod));
    }
    @GetMapping("/findall")
    public ResponseEntity<List<PartsModel>> findAll() {
        List<PartsModel> cod;
               cod = partsService.all();
        return ResponseEntity.status(HttpStatus.OK).body(cod);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
                 PartsModel partid = partsService.findPartsId(id);
            partsService.deleteParts(partid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("PECA REMOVIDO");
    }
}

