package com.example.projetoweb2bim.controller;

import com.example.projetoweb2bim.model.DTO.MedicoDTO;
import com.example.projetoweb2bim.model.DTO.MedicoUpdateDTO;
import com.example.projetoweb2bim.model.Medico;
import com.example.projetoweb2bim.services.MedicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description= "controlador rest responsavel pelas operaçoes que representam o objeto de negócios do médico")
@RestController
@RequestMapping(path = "/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping
    @ApiOperation("Inserir um novo médico")
    public Medico insert(@RequestBody @Valid Medico medico) throws Exception {
        return medicoService.insert(medico);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation("Editar os dados de um médico")
    public Medico edit(@PathVariable Long id, @RequestBody @Valid MedicoUpdateDTO request) throws Exception {
        Medico updatedMedico = medicoService.edit(id, request);
        return updatedMedico;
    }

    @GetMapping
    @ApiOperation("Obter todos os médicos")
    public List<MedicoDTO> findAll(@Valid Medico medico) {
        return medicoService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation("Obter um médico por ID")
    public Medico findById(@PathVariable Long id) {
        return medicoService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation("Excluir um médico por ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            medicoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}