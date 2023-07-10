package com.bike.shop.service;

import com.bike.shop.model.BikeModel;
import com.bike.shop.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;
    public BikeModel saveBike(BikeModel bikeModel){
       return bikeRepository.save(bikeModel);
    }
    public void deleteBike(BikeModel bikeModel){
       bikeRepository.delete(bikeModel);
    }
    public BikeModel findBikeId(Long id){
        return bikeRepository.findById(id).get();
    }
    public List<BikeModel> all(){
        return bikeRepository.findAll();
    }
}
