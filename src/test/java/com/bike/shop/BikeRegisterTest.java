package com.bike.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BikeRegisterTest {

    @Autowired
    public BikeService bikeService;
    private BikeModel bikeModel;

    @Test
    public void salvarBicicletaNoBanco() {

        bikeModel = new BikeModel();
        bikeModel.setId(30L);
        bikeModel.setBrand("caloi");
        bikeModel.setModel("caloi 10");
        bikeModel.setPrice(2500.0);
        bikeModel.setBikeType(bikeType.NEW);
        bikeModel.setYear("2023");
        bikeModel.setColor("preto");

        bikeService.saveBike(bikeModel);
    }
@Test
public void buscarBikeId(){

        bikeModel=bikeService.findBikeId(10L);

    Assertions.assertEquals("caloi",bikeModel.getBrand());
    Assertions.assertEquals("caloi 10",bikeModel.getModel());
    Assertions.assertEquals(2500.0,bikeModel.getPrice());
    Assertions.assertEquals("preto",bikeModel.getColor());
    Assertions.assertEquals("2023",bikeModel.getYear());

}


}
