package br.com.alura.clinica.application.consulta;

import java.time.LocalDateTime;

import br.com.alura.clinica.domain.consulta.Consulta;
import br.com.alura.clinica.domain.consulta.StatusConsulta;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DadosConsulta(
        @NotNull Long pacienteId,
        @NotNull Long medicoId,
        @NotNull @Future LocalDateTime data,
        StatusConsulta status) {

    public DadosConsulta(Consulta consulta) {
        this(consulta.getPaciente().getId(), consulta.getMedico().getId(), consulta.getData(), consulta.getStatus());
    }

}
