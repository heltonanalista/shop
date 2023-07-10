package com.bike.shop.service;

import com.bike.shop.dto.PartsModelDto;
import com.bike.shop.model.PartsModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConvertPartsService {
    private PartsModel partsModel;
    private PartsModelDto partsModelDto;
    public PartsModelDto partsDto(PartsModel partsModel) {
        this.partsModelDto = new PartsModelDto();
        BeanUtils.copyProperties(partsModel, partsModelDto);
        return partsModelDto;
    }
    public PartsModel partsEntity(PartsModelDto partsModelDto) {
        this.partsModel = new PartsModel();
        BeanUtils.copyProperties(partsModelDto, partsModel);
        return partsModel;
    }
}
