package com.example.projetoweb2bim.controller;

import com.example.projetoweb2bim.model.DTO.MedicoUpdateDTO;
import com.example.projetoweb2bim.model.DTO.PacienteDTO;
import com.example.projetoweb2bim.model.DTO.PacienteUpdateDTO;
import com.example.projetoweb2bim.model.Medico;
import com.example.projetoweb2bim.model.Paciente;
import com.example.projetoweb2bim.services.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@Api(description= "controlador rest responsavel pelas operaçoes que representam o objeto de negócios do paciente")
@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    @ApiOperation("Inserir um novo paciente")
    public Paciente insert(@RequestBody @Valid Paciente paciente) throws Exception {
        return pacienteService.insert(paciente);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation("Editar os dados de um paciente")
    public Paciente edit(@PathVariable Long id, @RequestBody @Valid PacienteUpdateDTO request) throws Exception {
        Paciente updatedPaciente = pacienteService.edit(id, request);
        return updatedPaciente;
    }

    @GetMapping
    @ApiOperation("Obter todos os pacientes")
    public List<PacienteDTO> findAll() {
        return pacienteService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation("Obter um paciente por ID")
    public Paciente findById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation("Excluir um paciente por ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}