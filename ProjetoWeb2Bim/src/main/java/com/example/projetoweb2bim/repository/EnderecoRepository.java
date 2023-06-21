package com.example.projetoweb2bim.repository;

import com.example.projetoweb2bim.model.Consulta;
import com.example.projetoweb2bim.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {


}
