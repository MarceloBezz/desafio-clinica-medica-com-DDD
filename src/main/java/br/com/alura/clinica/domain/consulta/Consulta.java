package br.com.alura.clinica.domain.consulta;

import java.time.Duration;
import java.time.LocalDateTime;

import br.com.alura.clinica.domain.medico.Medico;
import br.com.alura.clinica.domain.paciente.Paciente;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime data;
    private StatusConsulta status;

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setData(LocalDateTime data) {
        if (Duration.between(data, LocalDateTime.now()).toDays() < 2)
            throw new RuntimeException("Você só pode remarcar consultas com até dois dias de antecedência!");
        
        this.data = data;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
}
