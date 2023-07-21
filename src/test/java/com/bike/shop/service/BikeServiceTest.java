package com.bike.shop.service;

import com.bike.shop.dto.PartsModelDto;
import com.bike.shop.model.BikeModel;
import com.bike.shop.model.PartsModel;
import com.bike.shop.model.bikeType;
import com.bike.shop.repository.BikeRepository;
import com.bike.shop.repository.PartsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BikeServiceTest {
    @InjectMocks
    private BikeService bikeService;

    @Mock
    private BikeRepository bikeRepository;

    private BikeModel bike1, bike2, bike3, bike4, bike5;
    private List<BikeModel> listBikes;
    private List<Long> listIds;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bike1 = new BikeModel(1L,"caloi","caloi 10","2019","azul",789.0, bikeType.NEW);
        bike2 =  new BikeModel(1L,"monark ","monark 10","2022","preto",987.0, bikeType.NEW);
        bike3 =  new BikeModel(1L,"shimano ","xlx","2021","branco",679.0, bikeType.NEW);
        bike4 =  new BikeModel(1L,"first ","xx","2018","vermelho",898.0, bikeType.NEW);
        bike5 =  new BikeModel(1L,"gts","gt","2023","verde",768.0, bikeType.NEW);
        listBikes = new ArrayList<>();
        listBikes.add(bike1);
        listBikes.add(bike2);
        listBikes.add(bike3);
        listBikes.add(bike4);
        listBikes.add(bike3);
        listIds = new ArrayList<>();
        listIds.add(1L);
        listIds.add(2L);
        listIds.add(3L);
        listIds.add(4L);
        listIds.add(5L);
        listIds.add(6L);
    }

    @Test
    @DisplayName("whenSaveBikeThenReturnBike")
    void whenSaveBikeThenReturnBike() {

        Mockito.when(bikeRepository.save(Mockito.any())).thenReturn(bike1);

        BikeModel criado = bikeService.saveBike(bike1);


        Assertions.assertEquals(1, criado.getId());
        Assertions.assertEquals("caloi", criado.getBrand());
        Assertions.assertEquals("caloi 10", criado.getModel());
        Assertions.assertEquals("2019", criado.getYear());
        Assertions.assertEquals("azul", criado.getColor());
        Assertions.assertEquals(789.0, criado.getPrice());
    }

    @Test
    void deleteParts() {
    }

    @Test
    @DisplayName("whenFindBikeByIdThenReturnBike")
    void whenFindBikeByIdThenReturnBike() {
        Mockito.when(bikeRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(bike1));
        BikeModel retorno = bikeRepository.findById(bike1.getId()).get();

        Assertions.assertEquals(1, retorno.getId());
        Assertions.assertEquals("caloi", retorno.getBrand());
        Assertions.assertEquals("caloi 10", retorno.getModel());
        Assertions.assertEquals("2019", retorno.getYear());
        Assertions.assertEquals("azul", retorno.getColor());
        Assertions.assertEquals(789.0, retorno.getPrice());

    }

    @Test
    @DisplayName("whenFindAllBikesThenReturnAllBikes")
    void whenFindAllBikesThenReturnAllBikes() {
        Mockito.when(bikeRepository.findAll()).thenReturn(listBikes);
        List<BikeModel> listar = bikeService.all();
        Assertions.assertEquals(5, listar.size());
    }

    @Test
    @DisplayName("whenFindAllByIdPartsThenReturnAllParts")
    void whenFindAllByIdPartsThenReturnAllParts() {
        Mockito.when(bikeRepository.findAllById(Mockito.anyCollection())).thenReturn(listBikes);
        List<BikeModel> list = bikeService.allId(listIds);
        Assertions.assertEquals(5, list.size());
    }
}