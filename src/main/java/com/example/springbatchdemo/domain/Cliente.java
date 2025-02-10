package com.example.springbatchdemo.domain;

public class Cliente {

    private String nome;
    private String sobrenome;
    private String idade;
    private String email;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(final String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(final String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
            "nome='" + nome + '\'' +
            ", sobrenome='" + sobrenome + '\'' +
            ", idade='" + idade + '\'' +
            ", email='" + email + '\'' +
            '}';
    }

}
