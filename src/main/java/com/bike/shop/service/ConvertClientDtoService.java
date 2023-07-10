package com.bike.shop.service;

import com.bike.shop.dto.ClientModelDto;
import com.bike.shop.model.ClientModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConvertClientDtoService {
    private ClientModel clientModel;
    private ClientModelDto clientModelDto;
    public ClientModelDto clientDto(ClientModel clientModel) {
        this.clientModelDto = new ClientModelDto();
        BeanUtils.copyProperties(clientModel, clientModelDto);
        return clientModelDto;
    }
    public ClientModel clientEntity(ClientModelDto clientModelDto) {
        clientModel = new ClientModel();

        BeanUtils.copyProperties(clientModelDto, clientModel);
        return clientModel;
    }
}

