package com.example.aula26mesa.service;

import com.example.aula26mesa.dao.DentistaDAO;

import com.example.aula26mesa.model.Dentista;

import com.example.aula26mesa.repository.DentistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository repository; // chamar Repository

    public Map<Integer, Dentista> buscarDentista(){
        return repository.selectAll();
    }

    public Map<Integer, Dentista> buscarDentistaPorId(Integer id){
        return repository.select(id);
    }


    public String deletarDentista(Integer id){
        repository.delete(id);
        return  "Deletado com sucesso";
    }

    public Map<Integer, Dentista> criarDentista(DentistaDAO dao){
        Dentista dentista = new Dentista(dao.getNome(), dao.getSobrenome(), dao.getMatricula());

        return repository.create(dentista);
    }

    public Map<Integer, Dentista> editarDentista(DentistaDAO dao){
        Dentista dentista = new Dentista(dao.getNome(), dao.getSobrenome(), dao.getMatricula());

        return repository.update(dentista, dao.getId());
    }
}
