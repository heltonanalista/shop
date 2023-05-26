package com.bike.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "client")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private String fone;
    @NotBlank
    private String endereco;
    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;
    @NotBlank
    private String estado;

}
