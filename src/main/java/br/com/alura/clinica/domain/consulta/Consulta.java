package br.com.alura.clinica.domain.consulta;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import br.com.alura.clinica.domain.medico.Medico;
import br.com.alura.clinica.domain.paciente.Paciente;
import jakarta.persistence.*;

@Entity
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_crm")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    public Consulta(Medico medico, Paciente paciente, LocalDateTime data) {
        Objects.requireNonNull(medico, "O médico da consulta não pode ser nulo!");
        Objects.requireNonNull(paciente, "O paciente da consulta não pode ser nulo!");
        Objects.requireNonNull(data, "A data da consulta não pode ser nula!");
        if (LocalDateTime.now().isBefore(data))
            throw new RuntimeException("A consulta não pode ser agendada em uma data passada!");

        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.status = StatusConsulta.AGENDADA;
    }

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
        if (medico != null)
            this.medico = medico;
    }

    public void reagendar(LocalDateTime data) {
        if (Duration.between(data, LocalDateTime.now()).toDays() < 2)
            throw new RuntimeException("Você só pode remarcar consultas com até dois dias de antecedência!");
        
        this.data = data;
    }

    public void cancelaConsulta() {
        this.status = StatusConsulta.CANCELADA;
    }
}
