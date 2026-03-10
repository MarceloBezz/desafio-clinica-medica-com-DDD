package br.com.alura.clinica.application.consulta;

import org.springframework.stereotype.Service;

import br.com.alura.clinica.domain.consulta.Consulta;
import br.com.alura.clinica.domain.medico.Medico;
import br.com.alura.clinica.domain.paciente.Paciente;
import br.com.alura.clinica.infra.repositories.ConsultaRepository;
import br.com.alura.clinica.infra.repositories.MedicoRepository;
import br.com.alura.clinica.infra.repositories.PacienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultaService(ConsultaRepository consultaRepository, MedicoRepository medicoRepository,
            PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public Consulta agendarConsulta(DadosConsulta dto) {
        Medico medico = medicoRepository.findById(dto.medicoId())
                .orElseThrow(() -> new RuntimeException("ID do médico inválido!"));
        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("ID do paciente inválido!"));

        if (consultaRepository.findByDataAndMedico(dto.data(), medico).isPresent())
            throw new RuntimeException("Consulta já agendada com esse médico neste horário!");

        Consulta consulta = new Consulta(medico, paciente, dto.data());
        return consultaRepository.save(consulta);
    }

    public DadosConsulta buscarPorId(Long id) {
        var consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));

        return new DadosConsulta(consulta);
    }

    @Transactional
    public void cancelarConsulta(Long id) {
        var consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        consulta.cancelaConsulta(); 
    }

}
