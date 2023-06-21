package com.example.projetoweb2bim.model.DTO;

import com.example.projetoweb2bim.model.Paciente;

public class PacienteDTO {


    private String nome;
    private String email;
    private String cpf;




    public PacienteDTO(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public PacienteDTO(Paciente paciente) {
        this.cpf = paciente.getCpf();
        this.nome = paciente.getNome();
        this.email = paciente.getEmail();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
