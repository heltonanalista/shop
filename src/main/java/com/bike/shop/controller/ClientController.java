package com.bike.shop.controller;

import com.bike.shop.dto.ClientModelDto;
import com.bike.shop.model.ClientModel;
import com.bike.shop.service.ClientService;
import com.bike.shop.service.ConvertClientDtoService;
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
@RequestMapping("/client")
public class ClientController {
    @Autowired
    public ClientService clientService;
    @Autowired
    public ConvertClientDtoService convertClientDtoService;
    private ClientModel clientModel;
    @PostMapping("/register")
    public ResponseEntity<ClientModelDto> registerClient(@RequestBody @Valid ClientModelDto clientModelDto) {
        clientModel = convertClientDtoService.clientEntity(clientModelDto);
            clientService.saveClient(clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertClientDtoService.clientDto(clientModel));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
                 ClientModel clientid = clientService.findClientId(id);
           clientService.deleteClient(clientid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("CLIENTE NAO EXISTE");
    }
    @GetMapping("/findid/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        ClientModel cod;
               cod = clientService.findClientId(id);
                 return ResponseEntity.status(HttpStatus.OK).body(convertClientDtoService.clientDto(cod));
    }
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<ClientModel> cod;
                 cod = clientService.all();
        return ResponseEntity.status(HttpStatus.OK).body(cod);
    }
}
