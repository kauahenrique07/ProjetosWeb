package com.example.projetoweb2bim.repository;

import com.example.projetoweb2bim.model.Medico;
import com.example.projetoweb2bim.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findAllByOrderByNomeAsc();

}

