package com.example.Aula22Integradora.service;
import com.example.Aula22Integradora.dao.DentistaDAO;
import com.example.Aula22Integradora.domain.Dentista;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class DentistaService {
    private static Map<Integer, Dentista> flyweight = new HashMap<>();

    public Map<Integer, Dentista> buscarDentistas(){

        return flyweight;
    }

    public Dentista buscarDentistaId(Integer id){

        return flyweight.get(id);
    }

    public Dentista criarDentista(DentistaDAO dao){
        Integer id = flyweight.size()+1;
        Dentista dentista = new Dentista(dao.getNome(), dao.getSobrenome(), dao.getEmail(), dao.getCredencial());
        flyweight.put(id, dentista);

        return flyweight.get(id);
    }

    public Dentista editarDentista(DentistaDAO dao){
        Dentista dentista = flyweight.get(dao.getId());
        dentista.setNome(dao.getNome());
        dentista.setSobrenome(dao.getSobrenome());
        dentista.setEmail(dao.getEmail());

        return dentista;
    }

    public void deletarDentistaId(Integer id){
        flyweight.remove(id);
    }

}
