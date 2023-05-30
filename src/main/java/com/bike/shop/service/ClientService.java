package com.bike.shop.service;

import com.bike.shop.model.ClientModel;
import com.bike.shop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;


    public void saveClient(ClientModel clientModel) {

        clientRepository.save(clientModel);
    }

    public ClientModel findClientId(Long id) {
        return clientRepository.findById(id).get();

    }
    public void deleteClient(ClientModel clientModel){

        clientRepository.delete(clientModel);
    }

    public List<ClientModel> all() {
        return clientRepository.findAll();
    }
}



