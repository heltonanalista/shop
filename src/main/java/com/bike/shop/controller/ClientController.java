package com.bike.shop.controller;

import com.bike.shop.dto.PeopleModelDto;
import com.bike.shop.model.ClientModel;
import com.bike.shop.service.ClienttService;
import com.bike.shop.service.ConvertPeopleDtoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("register")
public class ClientController {
    @Autowired
    public ClienttService clienttService;
    @Autowired
    public ConvertPeopleDtoService convertPeopleDtoService;
    private ClientModel clientModel;

    @PostMapping("client")
    public ResponseEntity<?> registerClient(@RequestBody @Valid PeopleModelDto peopleModelDto) {
        System.out.println(peopleModelDto.getNome());
        clientModel = convertPeopleDtoService.clientEntity(peopleModelDto);
        System.out.println(clientModel.getNome());
        try {
            clienttService.savePeople(clientModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CAMPO NAO PODE SER VAZIO OU NULO");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(convertPeopleDtoService.clientDto(clientModel));
    }


}
