package com.bike.shop.controller;

import com.bike.shop.dto.MaintenanceModelDto;
import com.bike.shop.model.MaintenanceModel;
import com.bike.shop.service.ConvertMaintenanceService;
import com.bike.shop.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("maintenance")
public class MaintenanceController {
    public MaintenanceModel maintenanceModel;
    @Autowired
    public MaintenanceService maintenanceService;
    @Autowired
    public ConvertMaintenanceService convertMaintenanceService;

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody MaintenanceModelDto maintenanceModelDto) {
        System.out.println(maintenanceModelDto.getDescription());
        maintenanceModel = maintenanceService.saveMaintenance(convertMaintenanceService.maintenanceEntity(maintenanceModelDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(convertMaintenanceService.maintenanceDto(maintenanceModel));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            MaintenanceModel maintenanceid = maintenanceService.findMaintenanceId(id);
            maintenanceService.deleteMaintenance(maintenanceModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BICICLETA NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body("BICICLETA REMOVIDA");
    }

    @GetMapping("findid/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        MaintenanceModel cod;
        try {
            cod = maintenanceService.findMaintenanceId(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BICICLETA NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertMaintenanceService.maintenanceDto(cod));
    }
}
