package br.com.alura.clinica.infra.repositories;

import br.com.alura.clinica.domain.consulta.Consulta;
import br.com.alura.clinica.domain.medico.Medico;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Optional<Consulta> findByDataAndMedico(LocalDateTime data, Medico medico);
}
