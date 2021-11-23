package com.example.Aula18.service;

import com.example.Aula18.domain.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorServer implements IProfessor {

    @Override
    public List<Professor> listarProfessores() {
        List<Professor> lista = new ArrayList<>();

        lista.add(new Professor("Roberto", 32, "Matematica"));
        lista.add(new Professor("Julia", 28, "Historia"));
        lista.add(new Professor("Robson", 45, "Fisica"));

        return lista;

    }
}
