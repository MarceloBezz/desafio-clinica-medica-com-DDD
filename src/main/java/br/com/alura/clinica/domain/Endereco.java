package br.com.alura.clinica.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String rua;
    private String cep;
    private Integer numero;
    private String complemento;

    public Endereco(String rua, String cep, Integer numero, String complemento) {
        if (rua == null || rua.isEmpty() || cep == null || cep.isEmpty() || numero == null)
            throw new RuntimeException("Preencha o endereço corretamente!");
        
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}
