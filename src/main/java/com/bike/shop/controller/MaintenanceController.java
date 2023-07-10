package com.bike.shop.controller;

import com.bike.shop.dto.MaintenanceModelDto;
import com.bike.shop.model.MaintenanceModel;
import com.bike.shop.model.PartsModel;
import com.bike.shop.service.ConvertMaintenanceService;
import com.bike.shop.service.MaintenanceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
    public MaintenanceModel maintenanceModel;
    @Autowired
    public MaintenanceService maintenanceService;
    @Autowired
    public ConvertMaintenanceService convertMaintenanceService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MaintenanceModelDto maintenanceModelDto) {
        log.info("bikeshop controller valor {}"+maintenanceModelDto);
        maintenanceModel = maintenanceService.saveMaintenance(convertMaintenanceService.maintenanceEntity(maintenanceModelDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(convertMaintenanceService.maintenanceDto(maintenanceModel));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            MaintenanceModel maintenanceid = maintenanceService.findMaintenanceId(id);
            log.info("VALOR MANUTENCAO A SER REMOVIDA{}"+maintenanceid);
            maintenanceService.deleteMaintenance(maintenanceid);
        } catch (Exception e) {
            log.info("NAO REMOVEU MANUTENCAO EXCEPTION{}"+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NAO HA MANUTENCAO REGISTRADA");
        }
        return ResponseEntity.status(HttpStatus.OK).body("MANUTENCAO REMOVIDA");
    }
    @GetMapping("/findid/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        MaintenanceModel cod;
        try {
            cod = maintenanceService.findMaintenanceId(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NAO HA MANUTENCAO REGISTRADA");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertMaintenanceService.maintenanceDto(cod));
    }
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<MaintenanceModel> cod;
        try {
            cod = maintenanceService.all();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("MANUTENCAO NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cod);
    }
}
