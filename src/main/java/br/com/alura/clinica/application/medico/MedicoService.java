package br.com.alura.clinica.application.medico;

import br.com.alura.clinica.domain.medico.Medico;
import br.com.alura.clinica.infra.repositories.MedicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public DadosMedico cadastrar(DadosMedico dto) {
        Medico medico = new Medico(dto.nome(), dto.crm(), dto.especialidade(), dto.endereco());
        if (medicoRepository.findByCrmIgnoringCase(medico.getCrm()) != null)
            throw new RuntimeException("Médico com esse CRM já cadastrado!");

        return new DadosMedico(medicoRepository.save(medico));
    }

    public List<DadosMedico> buscaTodos() {
        return medicoRepository
                .findAll()
                .stream()
                .map(m -> new DadosMedico(m))
                .toList();
    }

    public DadosMedico buscarPorId(Long id) {
        Medico medico = medicoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ID do médico não encontrado!"));

        return new DadosMedico(medico);
    }

    @Transactional
    public DadosMedico atualizar(DadosAtualizaMedico dto, Long id) {
        Medico medico = medicoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ID do médico não encontrado!"));

        medico.alteraMedico(dto.especialidade(), dto.endereco());
        return new DadosMedico(medico);
    }

    @Transactional
    public void deletar(Long id) {
        Medico medico = medicoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ID do médico não encontrado!"));

        medicoRepository.delete(medico);
    }
}
