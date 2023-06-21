package com.example.projetoweb2bim.model.DTO;

import com.example.projetoweb2bim.model.MotivoCancelamento;

public class CancelamentoConsultaDTO {

    private String motivoCancelamento;

    public CancelamentoConsultaDTO() {
    }

    public CancelamentoConsultaDTO(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public MotivoCancelamento getMotivoCancelamentoAsEnum() {
        if (motivoCancelamento != null) {
            return MotivoCancelamento.valueOf(motivoCancelamento.toUpperCase());
        }
        return null;
    }
}