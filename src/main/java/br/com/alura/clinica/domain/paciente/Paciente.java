package br.com.alura.clinica.domain.paciente;

import br.com.alura.clinica.domain.Endereco;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Embedded
    private Endereco endereco;

    @Column(unique = true)
    private String email;

    public Paciente(String nome, String cpf, Endereco endereco, String email) {
        if (!cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}"))
            throw new RuntimeException("CPF em formato inválido!");

        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
            throw new RuntimeException("Email em formato inválido!");

        if (nome.isEmpty() || email.isEmpty())
            throw new IllegalArgumentException("Preencha todos os campos!");

        this.nome = Objects.requireNonNull(nome, "O nome é obrigatório");
        this.cpf = Objects.requireNonNull(cpf, "O CPF é obrigatório");
        this.endereco = Objects.requireNonNull(endereco, "O endereço é obrigatório");
        this.email = Objects.requireNonNull(email, "O email é obrigatório");
    }

    public void alteraPaciente(String nome, String email, Endereco endereco) {
        if (nome != null && !nome.isEmpty())
            this.nome = nome;
        if (email != null && !email.isEmpty())
            this.email = email;
        if (endereco != null)
            this.endereco = endereco;
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
}
