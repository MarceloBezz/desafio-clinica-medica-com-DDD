package br.com.alura.clinica.domain.paciente;

import br.com.alura.clinica.domain.Endereco;

public class Paciente {
    private String nome;
    private String cpf;
    private Endereco endereco;
    private String email;

    public Paciente(String nome, String cpf, Endereco endereco, String email) {
        if (!cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}"))
            throw new RuntimeException("CPF em formato inválido!");

        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
            throw new RuntimeException("Email em formato inválido!");

        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
