package com.example.aula26mesa.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PacienteDAO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
}
