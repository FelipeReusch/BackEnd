package com.example.Aula22Integradora.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Dentista {
    private String nome;
    private String sobrenome;
    private String email;
    private String credencial;

    public Dentista(String nome, String sobrenome, String email, String credencial) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.credencial = credencial;
    }
}
