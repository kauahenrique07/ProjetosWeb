package com.example.projetoweb2bim.model.DTO;

import java.time.LocalDateTime;

public class AgendamentoConsultaDTO {

    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime dataHoraConsulta;

    public AgendamentoConsultaDTO() {
    }

    public AgendamentoConsultaDTO(Long pacienteId, Long medicoId, LocalDateTime dataHoraConsulta) {
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }
}
