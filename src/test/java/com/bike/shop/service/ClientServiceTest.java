package com.bike.shop.service;

import com.bike.shop.model.BikeModel;
import com.bike.shop.model.ClientModel;
import com.bike.shop.model.bikeType;
import com.bike.shop.repository.BikeRepository;
import com.bike.shop.repository.ClientRepository;
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

class ClientServiceTest {
    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    private ClientModel client1,client2,client3,client4,client5;
    private List<ClientModel> listClient;
    private List<Long> listIds;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client1 = new ClientModel(1L,"helton silva","567456745","helton@teste.com","148594554","rua nove","bauru","179904353","sp");
        client2 =  new ClientModel(2L,"pedro santos","26247456745","pedro@teste.com","7356494554","rua oito","bauru","179904353","sp");
        client3=  new ClientModel(3L,"ana pereira","74256745","ana@teste.com","8547494554","rua sete","bauru","179904353","sp");
        client4=  new ClientModel(4L,"lucia prado","75556745","lucia@teste.com","85447554","rua cinco","bauru","179904353","sp");
        client5 =  new ClientModel(5L,"emilio paiva","346433745","emilio@teste.com","2464694554","rua quatro","bauru","179904353","sp");
        listClient = new ArrayList<>();
        listClient.add(client1);
        listClient.add(client2);
        listClient.add(client3);
        listClient.add(client4);
        listClient.add(client5);
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

        Mockito.when(clientRepository.save(Mockito.any())).thenReturn(client1);

        ClientModel criado = clientService.saveClient(client1);

        Assertions.assertEquals(1, criado.getId());
        Assertions.assertEquals("helton silva", criado.getNome());
        Assertions.assertEquals("567456745", criado.getCpf());
        Assertions.assertEquals("helton@teste.com", criado.getEmail());
        Assertions.assertEquals("148594554", criado.getFone());
        Assertions.assertEquals("rua nove", criado.getEndereco());
        Assertions.assertEquals("179904353", criado.getCep());
        Assertions.assertEquals("bauru", criado.getCidade());
        Assertions.assertEquals("sp", criado.getEstado());
    }

    @Test
    void deleteParts() {
    }

    @Test
    @DisplayName("whenFindBikeByIdThenReturnBike")
    void whenFindBikeByIdThenReturnBike() {
        Mockito.when(clientRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(client1));
        ClientModel retorno = clientService.findClientId(client1.getId());

        Assertions.assertEquals(1, retorno.getId());
        Assertions.assertEquals("helton silva", retorno.getNome());
        Assertions.assertEquals("567456745", retorno.getCpf());
        Assertions.assertEquals("helton@teste.com", retorno.getEmail());
        Assertions.assertEquals("148594554", retorno.getFone());
        Assertions.assertEquals("rua nove", retorno.getEndereco());
        Assertions.assertEquals("179904353", retorno.getCep());
        Assertions.assertEquals("bauru", retorno.getCidade());
        Assertions.assertEquals("sp", retorno.getEstado());

    }

    @Test
    @DisplayName("whenFindAllBikesThenReturnAllBikes")
    void whenFindAllBikesThenReturnAllBikes() {
        Mockito.when(clientRepository.findAll()).thenReturn(listClient);
        List<ClientModel> listar = clientService.all();
        Assertions.assertEquals(5, listar.size());
    }

    @Test
    @DisplayName("whenFindAllByIdPartsThenReturnAllParts")
    void whenFindAllByIdPartsThenReturnAllParts() {
        Mockito.when(clientRepository.findAllById(Mockito.anyCollection())).thenReturn(listClient);
        List<ClientModel> list = clientService.allId(listIds);
        Assertions.assertEquals(5, list.size());
    }


}