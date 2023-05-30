package com.bike.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModelDto {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String fone;
    private String endereco;
    private String cidade;
    private String cep;
    private String estado;
}




