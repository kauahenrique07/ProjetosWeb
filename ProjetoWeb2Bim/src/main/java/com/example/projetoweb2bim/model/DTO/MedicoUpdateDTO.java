package com.example.projetoweb2bim.model.DTO;

import com.example.projetoweb2bim.model.Endereco;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class MedicoUpdateDTO {

    private String nome;


    private String telefone;


    private Endereco endereco;

    public MedicoUpdateDTO(String nome, String telefone, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
