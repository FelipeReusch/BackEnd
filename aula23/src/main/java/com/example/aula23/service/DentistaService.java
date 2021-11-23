package com.example.aula23.service;

import com.example.aula23.dao.DentistaDAO;
import com.example.aula23.model.Dentista;

import java.util.HashMap;
import java.util.Map;

public class DentistaService {

    private static Map<Integer, Dentista> flyweight = new HashMap<>();

    public Map<Integer, Dentista> buscarDentista(){

        return flyweight;
    }

    public Dentista buscarDentistaId(Integer id){

        return flyweight.get(id);
    }

    public Dentista criarDentista(DentistaDAO dao){
        Integer id = flyweight.size() + 1;
        Dentista dentista = new Dentista(dao.getNome(), dao.getSobrenome(), dao.getMatricula());

        flyweight.put(id, dentista);

        return flyweight.get(id);
    }


    public Dentista editarDentista(DentistaDAO dao){
        Dentista dentista = flyweight.get(dao.getId());
        dentista.setNome(dao.getNome()); // editar nome
        dentista.setSobrenome(dao.getSobrenome()); // editar sobrenome
        dentista.setMatricula(dao.getMatricula()); // editar matricula

        return dentista;
    }

    public void deletarDentistaId(Integer id){
        flyweight.remove(id);
    }


}
