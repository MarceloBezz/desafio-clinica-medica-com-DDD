package br.com.alura.clinica.application.paciente;

import org.hibernate.validator.constraints.br.CPF;

import br.com.alura.clinica.domain.Endereco;
import br.com.alura.clinica.domain.paciente.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPaciente(
                @NotBlank String nome,

                @CPF @NotNull String cpf,

                @NotNull Endereco endereco,

                @NotBlank String email) {
        public DadosPaciente(Paciente paciente) {
                this(paciente.getNome(), paciente.getCpf(), paciente.getEndereco(), paciente.getEmail());
        }

}
