package com.example.projetoweb2bim.model;

import com.example.projetoweb2bim.model.Endereco;
import com.example.projetoweb2bim.model.Especialidade;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Medico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID do médico")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty("Nome do médico")
    private String nome;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(nullable = false, unique = true, updatable = false)
    @ApiModelProperty("E-mail do médico")
    private String email;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @ApiModelProperty("Telefone do médico")
    private String telefone;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(nullable = false, unique = true, updatable = false)
    @ApiModelProperty("CRM do médico")
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    @ApiModelProperty("Especialidade do médico")
    private Especialidade especialidade;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @ApiModelProperty("Endereço do médico")
    private Endereco endereco;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    @ApiModelProperty("Consultas associadas ao médico")
    private List<Consulta> consultas;

    @Column(nullable = false)
    @ApiModelProperty("Indica se o médico está ativo")
    private boolean ativo = true;

    public Medico() {
    }

    public Medico(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
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