package com.bike.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienttService {


    @Autowired
    private PeopleRepository peopleRepository;


    public void savePeople(PeopleModel peopleModel) {
        peopleRepository.save(peopleModel);
    }

}



