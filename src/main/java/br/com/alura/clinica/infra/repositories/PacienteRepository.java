package br.com.alura.clinica.infra.repositories;

import br.com.alura.clinica.domain.paciente.Paciente;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p WHERE p.cpf = :cpf")
    Optional<Paciente> findByCpf(String cpf);
}
