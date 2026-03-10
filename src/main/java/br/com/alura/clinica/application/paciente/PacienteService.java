package br.com.alura.clinica.application.paciente;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.alura.clinica.domain.paciente.Paciente;
import br.com.alura.clinica.infra.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrar(DadosPaciente dto) {
        Paciente paciente = new Paciente(dto.nome(), dto.cpf(), dto.endereco(), dto.email());
        if (pacienteRepository.findByCpf(dto.cpf()).isPresent())
            throw new IllegalArgumentException("CPF já cadastrado!");

        return pacienteRepository.save(paciente);
    }

    public List<DadosPaciente> buscaTodos() {
        return pacienteRepository
                .findAll()
                .stream()
                .map(m -> new DadosPaciente(m))
                .toList();
    }

    public DadosPaciente buscarPorId(Long id) {
        Paciente paciente = pacienteRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID do médico não encontrado!"));

        return new DadosPaciente(paciente);
    }

    @Transactional
    public DadosPaciente atualizar(DadosAtualizaPaciente dto, Long id) {
        Paciente paciente = pacienteRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID do médico não encontrado!"));

        paciente.alteraPaciente(dto.nome(), dto.email(), dto.endereco());
        return new DadosPaciente(paciente);
    }

    @Transactional
    public void deletar(Long id) {
        Paciente paciente = pacienteRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID do médico não encontrado!"));

        pacienteRepository.delete(paciente);
    }

}
