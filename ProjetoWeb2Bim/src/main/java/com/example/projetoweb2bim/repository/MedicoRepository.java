package com.example.projetoweb2bim.repository;


import com.example.projetoweb2bim.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findAllByOrderByNomeAsc();

}
