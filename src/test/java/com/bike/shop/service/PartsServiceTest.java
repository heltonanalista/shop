package com.bike.shop.service;

import com.bike.shop.dto.PartsModelDto;
import com.bike.shop.model.PartsModel;
import com.bike.shop.repository.PartsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(MockitoExtension.class)
class PartsServiceTest {
    @InjectMocks
    private PartsService partsService;
    @Mock
    private ConvertPartsService convertPartsService;
    @Mock
    private PartsRepository partsRepository;

    private PartsModel parts1, parts2, parts3, parts4, parts5;
    private List<PartsModel> listParts;
    private List<Long> listIds;
    private PartsModelDto partsModelDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        parts1 = new PartsModel(1L, "selim", "caloi", "xlx", 5, 146.0);
        parts2 = new PartsModel(2L, "guidom", "caloi", "ts", 1, 150.0);
        parts3 = new PartsModel(3L, "garfo", "caloi", "gs", 2, 400.0);
        parts4 = new PartsModel(4L, "pneu", "caloi", "gs", 4, 145.0);
        parts5 = new PartsModel(5L, "quadro", "caloi", "tt", 3, 789.0);
        listParts = new ArrayList<>();
        listParts.add(parts1);
        listParts.add(parts2);
        listParts.add(parts3);
        listParts.add(parts4);
        listParts.add(parts5);
        listIds = new ArrayList<>();
        listIds.add(1L);
        listIds.add(2L);
        listIds.add(3L);
        listIds.add(4L);
        listIds.add(5L);
        listIds.add(6L);
    }

    @Test
    @DisplayName("whenSavePartsThenReturnParts")
    void whenSavePartsThenReturnParts() {

        Mockito.when(partsRepository.save(Mockito.any())).thenReturn(parts1);

        PartsModel criado = partsService.saveParts(parts1);


        Assertions.assertEquals(1, criado.getId());
        Assertions.assertEquals("selim", criado.getName());
        Assertions.assertEquals("caloi", criado.getBrand());
        Assertions.assertEquals("xlx", criado.getModel());
        Assertions.assertEquals(5, criado.getQuantity());
        Assertions.assertEquals(146.0, criado.getPrice());
    }

    @Test
    void deleteParts() {
    }

    @Test
    @DisplayName("whenFindPartsByIdThenReturnParts")
    void whenFindPartsByIdThenReturnParts() {
        Mockito.when(partsRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(parts1));
        PartsModel retorno = partsService.findPartsId(parts1.getId());

        Assertions.assertEquals(1, retorno.getId());
        Assertions.assertEquals("selim", retorno.getName());
        Assertions.assertEquals("caloi", retorno.getBrand());
        Assertions.assertEquals("xlx", retorno.getModel());
        Assertions.assertEquals(5, retorno.getQuantity());
        Assertions.assertEquals(146.0, retorno.getPrice());

    }

    @Test
    @DisplayName("whenFindAllPartsThenReturnAllParts")
    void whenFindAllPartsThenReturnAllParts() {
        Mockito.when(partsRepository.findAll()).thenReturn(listParts);
        List<PartsModel> listar = partsService.all();
        Assertions.assertEquals(5, listar.size());
    }

    @Test
    @DisplayName("whenFindAllByIdPartsThenReturnAllParts")
    void whenFindAllByIdPartsThenReturnAllParts() {
        Mockito.when(partsRepository.findAllById(Mockito.anyCollection())).thenReturn(listParts);
        List<PartsModel> list = partsService.allId(listIds);
        Assertions.assertEquals(5, list.size());
    }
}