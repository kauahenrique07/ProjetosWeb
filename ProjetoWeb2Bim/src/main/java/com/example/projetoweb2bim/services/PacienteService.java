package com.example.projetoweb2bim.services;


import com.example.projetoweb2bim.model.DTO.MedicoDTO;
import com.example.projetoweb2bim.model.DTO.MedicoUpdateDTO;
import com.example.projetoweb2bim.model.DTO.PacienteDTO;
import com.example.projetoweb2bim.model.DTO.PacienteUpdateDTO;
import com.example.projetoweb2bim.model.Medico;
import com.example.projetoweb2bim.model.Paciente;
import com.example.projetoweb2bim.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente insert(Paciente paciente) throws Exception{
        pacienteRepository.saveAndFlush(paciente);
        return paciente;
    }

    public Paciente edit (Long id, PacienteUpdateDTO request) throws Exception{
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Paciente com id: " + id + "não encontrado"));
        paciente.setNome(request.getNome());
        paciente.setTelefone(request.getTelefone());
        paciente.setEndereco(request.getEndereco());

        return pacienteRepository.save(paciente);
    }

    public List<PacienteDTO> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAllByOrderByNomeAsc();
        return pacientes.stream()
                .map(paciente -> new PacienteDTO(paciente))
                .collect(Collectors.toList());
    }

    public void delete(Long id) throws Exception {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new Exception("Médico não encontrado"));
        paciente.setAtivo(false);
        pacienteRepository.saveAndFlush(paciente);
    }

    public Paciente findById(Long id){
        Optional<Paciente> retorno = pacienteRepository.findById(id);
        return retorno.get();
    }


}
