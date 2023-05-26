package com.bike.shop.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "parts")
public class PartsModel {
    @Id
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotNull
    private Integer quantidade;
    @NotNull
    private Double preco;

}