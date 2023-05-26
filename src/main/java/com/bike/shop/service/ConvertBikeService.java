package com.bike.shop.service;

import com.bike.shop.dto.BikeModelDto;
import com.bike.shop.model.BikeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConvertBikeService {
    private BikeModel bikeModel;
    private BikeModelDto bikeModelDto;

    public BikeModelDto bikeDto(BikeModel bikeModel) {
        this.bikeModelDto = new BikeModelDto();
        BeanUtils.copyProperties(bikeModel,bikeModelDto);

        return this.bikeModelDto;

    }


    public BikeModel bikeEntity(BikeModelDto bikeModelDto) {

        bikeModel = new BikeModel();
        BeanUtils.copyProperties(bikeModelDto,bikeModel);

        return this.bikeModel;

    }
  /*  public List<BikeModelDto> listAll(List <BikeModel> bikeModelList){

        return bikeModelList.stream()
                .map(BikeModelDto::new)
                .collect(Collectors.toList());

    }
    */
  
}
