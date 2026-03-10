package br.com.alura.clinica.domain.medico;

import br.com.alura.clinica.domain.Endereco;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico() {}

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
