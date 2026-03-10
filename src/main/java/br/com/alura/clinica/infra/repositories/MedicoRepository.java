package br.com.alura.clinica.infra.repositories;

import br.com.alura.clinica.domain.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico findByCrmIgnoringCase(String crm);
}
