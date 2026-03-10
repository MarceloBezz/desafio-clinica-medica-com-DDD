package br.com.alura.clinica.application.medico;

import br.com.alura.clinica.domain.Endereco;
import br.com.alura.clinica.domain.medico.Especialidade;

public record DadosAtualizaMedico(
        Especialidade especialidade,
        Endereco endereco
) {
}
