package com.bike.shop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModelDto {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    @Email
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




