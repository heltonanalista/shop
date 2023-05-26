package com.bike.shop.service;

import com.bike.shop.dto.PeopleModelDto;
import com.bike.shop.model.ClientModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConvertPeopleDtoService {


    private ClientModel clientModel;
    private PeopleModelDto peopleModelDto;
    private EmployeeModel employeeModel;
    private SupplierModel supplierModel;

    public PeopleModelDto clientDto(ClientModel clientModel) {
        this.peopleModelDto = new PeopleModelDto();
        BeanUtils.copyProperties(clientModel, peopleModelDto);
        return peopleModelDto;
    }

    public PeopleModelDto employeeDto(EmployeeModel employeeModel) {
        this.peopleModelDto = new PeopleModelDto();
        BeanUtils.copyProperties(employeeModel, peopleModelDto);
        return peopleModelDto;
    }

    public PeopleModelDto supplierDto(SupplierModel supplierModel) {
        this.peopleModelDto = new PeopleModelDto();
        BeanUtils.copyProperties(supplierModel, peopleModelDto);
        return peopleModelDto;
    }

    public ClientModel clientEntity(PeopleModelDto peopleModelDto) {
        clientModel = new ClientModel();

        BeanUtils.copyProperties(peopleModelDto, clientModel);
        return clientModel;
    }

    public EmployeeModel employeeEntity(PeopleModelDto peopleModelDto) {
        employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(peopleModelDto, employeeModel);
        return employeeModel;
    }


    public SupplierModel supplierentity(PeopleModelDto peopleModelDto) {
        supplierModel = new SupplierModel();
        BeanUtils.copyProperties(peopleModelDto, supplierModel);
        return supplierModel;
    }
    // public List<PeopleModelDto> listAll(List<ClientModel> clientModellList) {

    //   return clientModellList.stream().map(PeopleModelDto::new).collect(Collectors.toList());

    //  }
}

