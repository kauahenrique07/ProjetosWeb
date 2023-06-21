package com.example.projetoweb2bim.controller;

import com.example.projetoweb2bim.model.Consulta;
import com.example.projetoweb2bim.model.DTO.AgendamentoConsultaDTO;
import com.example.projetoweb2bim.model.DTO.CancelamentoConsultaDTO;
import com.example.projetoweb2bim.services.ConsultaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description= "controlador rest responsavel pelas operaçoes que representam o objeto de negócios da consulta")
@RestController
@RequestMapping(path = "/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @ApiOperation("Agendar uma consulta")
    public Consulta agendarConsulta(@RequestBody AgendamentoConsultaDTO agendamento) throws Exception {
        return consultaService.agendarConsulta(agendamento.getMedicoId(), agendamento.getPacienteId(), agendamento.getDataHoraConsulta());
    }

    @PutMapping(path = "/cancelar/{id}")
    @ApiOperation("Cancelar uma consulta")
    public Consulta cancelarConsulta(@PathVariable Long id, @RequestBody CancelamentoConsultaDTO cancelamento) throws Exception {
        return consultaService.cancelarConsulta(id, cancelamento.getMotivoCancelamentoAsEnum());
    }
}