package com.example.aula23.service;

import com.example.aula23.dao.DentistaDAO;
import com.example.aula23.dao.PacienteDAO;
import com.example.aula23.model.Dentista;
import com.example.aula23.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class PacienteService {

    private static Map<Integer, Paciente> flyweight = new HashMap<>();

    public Map<Integer, Paciente> buscarPaciente(){

        return flyweight;
    }

    public Paciente buscarPacienteId(Integer id){

        return flyweight.get(id);
    }

    public Paciente criarPaciente(PacienteDAO dao){
        Integer id = flyweight.size() + 1;
        Paciente paciente = new Paciente(dao.getNome(), dao.getSobrenome(), dao.getEmail(), dao.getIdade());

        flyweight.put(id, paciente);

        return flyweight.get(id);
    }


    public Paciente editarPaciente(PacienteDAO dao){
        Paciente paciente = flyweight.get(dao.getId());
        paciente.setNome(dao.getNome()); // editar nome
        paciente.setSobrenome(dao.getSobrenome()); // editar sobrenome
        paciente.setEmail(dao.getEmail()); // editar matricula
        paciente.setIdade(dao.getIdade());

        return paciente;
    }

    public void deletarPacienteId(Integer id){
        flyweight.remove(id);
    }

}
