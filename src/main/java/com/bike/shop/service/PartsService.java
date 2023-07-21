package com.bike.shop.service;

import com.bike.shop.model.PartsModel;
import com.bike.shop.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartsService {
    @Autowired
    private PartsRepository partsRepository;

    public PartsModel saveParts(PartsModel partsModel) {
        return partsRepository.save(partsModel);
    }

    public void deleteParts(PartsModel partsModel) {
        partsRepository.delete(partsModel);
    }

    public PartsModel findPartsId(Long id) {
        return partsRepository.findById(id).get();
    }

    public List<PartsModel> all() {
        return partsRepository.findAll();
    }

    public List<PartsModel> allId(List<Long> ids) {
        return partsRepository.findAllById(ids);
    }
}

