package br.com.alura.clinica.infra.repositories;

import br.com.alura.clinica.domain.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
