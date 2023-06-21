package com.example.projetoweb2bim.services;


import com.example.projetoweb2bim.model.DTO.MedicoDTO;
import com.example.projetoweb2bim.model.DTO.MedicoUpdateDTO;
import com.example.projetoweb2bim.model.Medico;
import com.example.projetoweb2bim.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public Medico insert(Medico medico) throws Exception{
        medicoRepository.saveAndFlush(medico);
        return medico;
    }

    public Medico edit (Long id, MedicoUpdateDTO request) throws Exception{
        Medico medico = medicoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Medico com id: " + id + "não encontrado"));
        medico.setNome(request.getNome());
        medico.setTelefone(request.getTelefone());
        medico.setEndereco(request.getEndereco());

        return medicoRepository.save(medico);
    }

    public List<MedicoDTO> findAll() {
        List<Medico> medicos = medicoRepository.findAllByOrderByNomeAsc();
        return medicos.stream().map(MedicoDTO::new).collect(Collectors.toList());
    }

    public Medico findById(Long id){
        Optional<Medico> retorno = medicoRepository.findById(id);
        return retorno.get();
    }

    public void delete(Long id) throws Exception {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new Exception("Médico não encontrado"));
        medico.setAtivo(false);
        medicoRepository.save(medico);
    }

}
