package com.bike.shop.dto;

public class PeopleModelDto {
    private Long id;
    private String nome;

    private String cpf;

    private String email;

    private String fone;

    private String endereco;

    private String cidade;

    private String cep;

    private String estado;


    private String cargo;
    private Double salario;
    private String razao_social;
    private String cnpj;



    public PeopleModelDto() {
    }

    public PeopleModelDto(Long id, String nome, String cpf, String email, String fone, String endereco, String cidade, String cep, String estado,  String cargo, Double salario, String razao_social, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.fone = fone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;

        this.cargo = cargo;
        this.salario = salario;
        this.razao_social = razao_social;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}