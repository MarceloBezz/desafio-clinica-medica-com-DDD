package br.com.alura.clinica.domain.medico;

import br.com.alura.clinica.domain.Endereco;

public class Medico {
    private String nome;
    private String crm;
    private Especialidade especialidade;
    private Endereco endereco;

    public Medico(String nome, String crm, Especialidade especialidade, Endereco endereco) {
        if (nome == null || crm == null || endereco == null || especialidade == null) {
            throw new RuntimeException("Preencha as informações do cadastro corretamente!");
        }
    
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
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

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
