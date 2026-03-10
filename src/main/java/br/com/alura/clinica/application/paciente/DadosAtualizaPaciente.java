package br.com.alura.clinica.application.paciente;

import br.com.alura.clinica.domain.Endereco;

public record DadosAtualizaPaciente(
    String nome,
    String email,
    Endereco endereco
) {
}
    