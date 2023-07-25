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
        try {
            ClientModel clientid = clientService.findClientId(id);
            clientService.deleteClient(clientid);
            log.info("CLIENTE-CONTROLLER = CLIENTE removida com sucesso");
        } catch (DataIntegrityViolationException e) {
            log.info("CLIENTE-CONTROLLER = erro ao remover CLIENTE foreignkey");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CLIENTE NAO PODE SER REMOVIDO POIS ESTA EM USO");
        } catch (Exception e) {
            log.info("CLIENTE-CONTROLLER = CLIENTE nao existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CLIENTE NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body("CLIENTE REMOVIDO");
    }
    @GetMapping("/findid/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        ClientModel cod;
        try {
            cod = clientService.findClientId(id);
            log.info("CLIENTE-CONTROLLER = retorna CLIENTE por id");
        } catch (Exception e) {
            log.info("CLIENTE-CONTROLLER = erro ao buscar CLIENTE por id, nao existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CLIENTE NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertClientDtoService.clientDto(cod));
    }
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<ClientModel> cod;
        try {
            cod = clientService.all();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CLIENTE NAO EXISTE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cod);
    }
}
