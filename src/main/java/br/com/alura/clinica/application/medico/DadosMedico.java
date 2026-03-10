package br.com.alura.clinica.application.medico;

import br.com.alura.clinica.domain.Endereco;
import br.com.alura.clinica.domain.medico.Especialidade;
import br.com.alura.clinica.domain.medico.Medico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosMedico(
    @NotBlank(message = "Preencha o nome do médico!")
    String nome,

    @NotBlank(message = "Preencha o CRM do médico!")
    String crm,

    @NotNull(message = "Preencha a especialidade do médico!")
    Especialidade especialidade,

    @NotNull(message = "Preencha o endereço do médico!")
    Endereco endereco
) {

    public DadosMedico(Medico medico) {
        this(medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
