package com.example.projetoweb2bim.model;

import com.example.projetoweb2bim.model.Medico;
import com.example.projetoweb2bim.model.Paciente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@ApiModel("Detalhes da Consulta")
@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID da consulta")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    @ApiModelProperty("Paciente associado à consulta")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    @ApiModelProperty("Médico associado à consulta")
    private Medico medico;

    @Column(nullable = false)
    @ApiModelProperty("Data e hora da consulta")
    private LocalDateTime dataHoraConsulta;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Motivo de cancelamento da consulta")
    private MotivoCancelamento motivoCancelamento;

    public Consulta() {
    }

    public Consulta(Long id, Paciente paciente, Medico medico, LocalDateTime dataHoraConsulta, MotivoCancelamento motivoCancelamento) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataHoraConsulta = dataHoraConsulta;
        this.motivoCancelamento = motivoCancelamento;
    }

    public MotivoCancelamento getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(MotivoCancelamento motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }
}