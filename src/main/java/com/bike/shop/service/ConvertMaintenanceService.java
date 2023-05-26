package com.bike.shop.service;

import com.bike.shop.dto.MaintenanceModelDto;
import com.bike.shop.model.MaintenanceModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConvertMaintenanceService {

    private MaintenanceModel maintenanceModel;
    private MaintenanceModelDto maintenanceModelDto;
    public MaintenanceModelDto maintenanceDto(MaintenanceModel maintenanceModel) {
        System.out.println("aqui");
        maintenanceModelDto= new MaintenanceModelDto();
        BeanUtils.copyProperties( maintenanceModel,maintenanceModelDto);
        return maintenanceModelDto;
    }


    public MaintenanceModel maintenanceEntity(MaintenanceModelDto maintenanceModelDto) {
        System.out.println("aqui tambem");
        maintenanceModel = new MaintenanceModel();
        BeanUtils.copyProperties( maintenanceModelDto,maintenanceModel);
        return maintenanceModel;

    }

}
