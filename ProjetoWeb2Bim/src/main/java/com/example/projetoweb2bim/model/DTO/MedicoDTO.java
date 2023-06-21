package com.example.projetoweb2bim.model.DTO;

import com.example.projetoweb2bim.model.Especialidade;
import com.example.projetoweb2bim.model.Medico;

public class MedicoDTO {

    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;

    public MedicoDTO(Medico medico) {
        this.nome = medico.getNome();
        this.email = medico.getEmail();
        this.crm = medico.getCrm();
        this.especialidade = medico.getEspecialidade();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
