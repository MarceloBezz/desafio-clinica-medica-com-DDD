package br.com.alura.clinica.domain.medico;

import br.com.alura.clinica.domain.Endereco;

import java.util.Objects;

public class Medico {
    private String nome;
    private String crm;
    private Especialidade especialidade;
    private Endereco endereco;

    public Medico(String nome, String crm, Especialidade especialidade, Endereco endereco) {
        if (nome.isEmpty() || crm.isEmpty())
            throw new IllegalArgumentException("Preencha todos os campos corretamente!");

        this.nome = Objects.requireNonNull(nome, "Nome é obrigatório");
        this.crm = Objects.requireNonNull(crm, "CRM é obrigatório");
        this.especialidade = Objects.requireNonNull(especialidade, "Especialidade é obrigatória");
        this.endereco = Objects.requireNonNull(endereco, "Endereço é obrigatório");
    }

    public void alteraMedico(Especialidade especialidade, Endereco endereco) {
        if (especialidade != null)
            this.especialidade = especialidade;
        if (endereco != null)
            this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
