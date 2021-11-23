package com.example.aula26mesa.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dentista {
    private String nome;
    private String sobrenome;
    private String matricula;

    public Dentista(String nome, String sobrenome, String matricula) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
    }
}