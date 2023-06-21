package com.example.projetoweb2bim.repository;

import com.example.projetoweb2bim.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    List<Consulta> findByDataHoraConsultaBetween(LocalDateTime start, LocalDateTime end);
    List<Consulta> findByDataHoraConsulta(LocalDateTime dataHoraConsulta);

}