package com.example.projetoweb2bim.services;

import com.example.projetoweb2bim.model.Consulta;
import com.example.projetoweb2bim.model.Medico;
import com.example.projetoweb2bim.model.MotivoCancelamento;
import com.example.projetoweb2bim.model.Paciente;
import com.example.projetoweb2bim.repository.ConsultaRepository;
import com.example.projetoweb2bim.repository.MedicoRepository;
import com.example.projetoweb2bim.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // Método pra agendar uma consulta
    public Consulta agendarConsulta(Long medicoId, Long pacienteId, LocalDateTime dataHoraConsulta) throws Exception {


        Consulta consulta = new Consulta();
        Medico medico = medicoRepository.findById(medicoId).orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHoraConsulta(dataHoraConsulta);

        validarHorarioConsulta(dataHoraConsulta);
        validarPacienteMedicoAtivos(paciente, medico);
        validarConsultaPacienteNoMesmoDia(paciente, dataHoraConsulta);
        validarConsultaMedicoNoMesmoHorario(medico, dataHoraConsulta);

        return consultaRepository.saveAndFlush(consulta);
    }

    public Consulta cancelarConsulta(Long consultaId, MotivoCancelamento motivoCancelamento) throws Exception {
        Consulta consulta = consultaRepository.findById(consultaId).orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada"));
        validarCancelamentoComAntecedencia(consulta.getDataHoraConsulta());
        consulta.setMotivoCancelamento(motivoCancelamento);

        return consultaRepository.save(consulta);
    }

    private void validarHorarioConsulta(LocalDateTime dataHoraConsulta) throws Exception {

        if (dataHoraConsulta.isBefore(LocalDateTime.now().plusMinutes(30))) {
            throw new Exception("As consultas devem ser agendadas com pelo menos 30 minutos de antecedência.");
        }
        if (dataHoraConsulta.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new Exception("A clínica não funciona aos domingos.");
        }
        int horaConsulta = dataHoraConsulta.getHour();
        if (horaConsulta < 7 || horaConsulta >= 19) {
            throw new Exception("A clínica funciona das 07:00 às 19:00.");
        }
    }

    private void validarPacienteMedicoAtivos(Paciente paciente, Medico medico) throws Exception {
        if (!paciente.isAtivo()) {
            throw new Exception("O paciente não está ativo no sistema.");
        }

        if (!medico.isAtivo()) {
            throw new Exception("O médico não está ativo no sistema.");
        }
    }

    private void validarConsultaPacienteNoMesmoDia(Paciente paciente, LocalDateTime dataHoraConsulta) throws Exception {
        List<Consulta> consultasDoDia = consultaRepository.findByDataHoraConsultaBetween(dataHoraConsulta.toLocalDate().atStartOfDay(), dataHoraConsulta.toLocalDate().atTime(23, 59, 59));

        if (consultasDoDia.stream().anyMatch(consulta -> consulta.getPaciente().equals(paciente))) {
            throw new Exception("O paciente já tem uma consulta agendada para este dia.");
        }
    }

    private void validarConsultaMedicoNoMesmoHorario(Medico medico, LocalDateTime dataHoraConsulta) throws Exception {
        List<Consulta> consultasNoMesmoHorario = consultaRepository.findByDataHoraConsulta(dataHoraConsulta);

        if (consultasNoMesmoHorario.stream().anyMatch(consulta -> consulta.getMedico().equals(medico))) {
            throw new Exception("O médico já tem uma consulta agendada para este horário.");
        }
    }

    private void validarCancelamentoComAntecedencia(LocalDateTime dataHoraConsulta) throws Exception {
        if (dataHoraConsulta.isBefore(LocalDateTime.now().plusHours(24))) {
            throw new Exception("A consulta só pode ser cancelada com no mínimo 24 horas de antecedência.");
        }
    }


}


