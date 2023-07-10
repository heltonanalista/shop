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
    public ResponseEntity<?> register(@RequestBody @Valid PartsModelDto partsModelDto) {
        System.out.println(partsModelDto.getModel());
            try {
            partsModel = partsService.saveParts(convertPartsService.partsEntity(partsModelDto));
            System.out.println(partsModel);
            log.info("valor pecas{}"+partsModel);
            log.info("PECA-CONTROLLER = PECA registrada");
        } catch (Exception e) {
            log.info("PECA-CONTROLLER = erro ao registrar PECA");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CAMPO NAO PODE SER VAZIO OU NULO");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(convertPartsService.partsDto(partsModel));
    }
    @GetMapping("/findid/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        PartsModel cod;
        try {
            cod = partsService.findPartsId(id);
            log.info("PECA-CONTROLLER = retorna PECA por id");
        } catch (Exception e) {
            log.info("PECA-CONTROLLER = erro ao buscar PECA por id, nao existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PECA NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertPartsService.partsDto(cod));
    }
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<PartsModel> cod;
        try {
            cod = partsService.all();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PECA NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cod);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            PartsModel partid = partsService.findPartsId(id);
            partsService.deleteParts(partid);
            log.info("PECA-CONTROLLER = PECA removida com sucesso");
        } catch (DataIntegrityViolationException e) {
            log.info("PECA-CONTROLLER = erro ao remover PECA foreignkey");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PECA NAO PODE SER REMOVIDO POIS ESTA EM USO");
        } catch (Exception e) {
            log.info("PECA-CONTROLLER = PECA nao existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PECA NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body("PECA REMOVIDO");
    }
}

