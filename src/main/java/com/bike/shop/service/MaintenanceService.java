package com.bike.shop.service;

import com.bike.shop.model.MaintenanceModel;
import com.bike.shop.repository.MaintenanceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;
    public MaintenanceModel saveMaintenance(MaintenanceModel maintenanceModel){
        return maintenanceRepository.save(maintenanceModel);
    }
    public void deleteMaintenance(MaintenanceModel maintenanceModel){
        log.info("MANUTENCAO SERVICE REMOVER MANUTENCAO {}"+maintenanceModel);
        maintenanceRepository.delete(maintenanceModel);
    }
    public MaintenanceModel findMaintenanceId(Long id){
        return maintenanceRepository.findById(id).get();
    }
    public List<MaintenanceModel> all(){
        return maintenanceRepository.findAll();
    }
}
