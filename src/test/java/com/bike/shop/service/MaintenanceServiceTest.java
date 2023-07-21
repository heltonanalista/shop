package com.bike.shop.service;

import com.bike.shop.model.*;
import com.bike.shop.repository.ClientRepository;
import com.bike.shop.repository.MaintenanceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceServiceTest {
    @InjectMocks
    private MaintenanceService maintenanceService;

    @Mock
    private MaintenanceRepository maintenanceRepository;
    private ClientModel client1,client2,client3,client4,client5;

    private MaintenanceModel maintenance1,maintenance2,maintenance3,maintenance4,maintenance5;
    private BikeModel bike1, bike2, bike3, bike4, bike5;
    private PartsModel parts1, parts2, parts3, parts4, parts5;
    private List<MaintenanceModel> listMaintenance;
    private List<Long> listIds;
    private List<PartsModel> listParts;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client1 = new ClientModel(1L,"helton silva","567456745","helton@teste.com","148594554","rua nove","bauru","179904353","sp");
        client2 =  new ClientModel(2L,"pedro santos","26247456745","pedro@teste.com","7356494554","rua oito","bauru","179904353","sp");
        client3=  new ClientModel(3L,"ana pereira","74256745","ana@teste.com","8547494554","rua sete","bauru","179904353","sp");
        client4=  new ClientModel(4L,"lucia prado","75556745","lucia@teste.com","85447554","rua cinco","bauru","179904353","sp");
        client5 =  new ClientModel(5L,"emilio paiva","346433745","emilio@teste.com","2464694554","rua quatro","bauru","179904353","sp");
        bike1 = new BikeModel(1L,"caloi","caloi 10","2019","azul",789.0, bikeType.NEW);
        bike2 =  new BikeModel(1L,"monark ","monark 10","2022","preto",987.0, bikeType.NEW);
        bike3 =  new BikeModel(1L,"shimano ","xlx","2021","branco",679.0, bikeType.NEW);
        bike4 =  new BikeModel(1L,"first ","xx","2018","vermelho",898.0, bikeType.NEW);
        bike5 =  new BikeModel(1L,"gts","gt","2023","verde",768.0, bikeType.NEW);
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
        maintenance1 = new MaintenanceModel(1L,LocalDateTime.now(),bike1,client1,"manutencao geral",listParts,250.0,0.0);
        maintenance2 = new MaintenanceModel(2L,LocalDateTime.now(),bike2,client2,"manutencao geral",listParts,250.0,0.0);    listMaintenance = new ArrayList<>();
        maintenance3 = new MaintenanceModel(3L, LocalDateTime.now(), bike3, client3, "manutencao geral", listParts, 250.0, 0.0);
        maintenance4 = new MaintenanceModel(4L, LocalDateTime.now(), bike4, client4, "manutencao geral", listParts, 250.0, 0.0);
        maintenance5 = new MaintenanceModel(5L, LocalDateTime.now(), bike5, client5, "manutencao geral", listParts, 250.0, 0.0);
        listMaintenance = new ArrayList<>();
        listMaintenance.add(maintenance1);
        listMaintenance.add(maintenance2);
        listMaintenance.add(maintenance3);
        listMaintenance.add(maintenance4);
        listMaintenance.add(maintenance5);
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