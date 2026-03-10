package br.com.alura.clinica.infra.repositories;

import br.com.alura.clinica.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
