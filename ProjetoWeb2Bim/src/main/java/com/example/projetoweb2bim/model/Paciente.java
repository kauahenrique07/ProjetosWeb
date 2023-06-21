package com.example.projetoweb2bim.model;

import com.example.projetoweb2bim.model.Endereco;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


import java.io.Serializable;
import java.util.List;

@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID do paciente")
    private Long id;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(nullable = false)
    @ApiModelProperty("Nome do paciente")
    private String nome;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true, updatable = false)
    @ApiModelProperty("E-mail do paciente")
    private String email;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(nullable = false)
    @ApiModelProperty("Telefone do paciente")
    private String telefone;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true, updatable = false)
    @ApiModelProperty("CPF do paciente")
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @ApiModelProperty("Endereço do paciente")
    private Endereco endereco;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @ApiModelProperty("Consultas associadas ao paciente")
    private List<Consulta> consultas;

    @Column(nullable = false)
    @ApiModelProperty("Indica se o paciente está ativo")
    private boolean ativo = true;

    public Paciente() {
    }

    public Paciente(Long id, String nome, String email, String telefone, String cpf, Endereco endereco, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = ativo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}