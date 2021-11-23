package com.example.Aula22Integradora.controller;
import com.example.Aula22Integradora.dao.DentistaDAO;
import com.example.Aula22Integradora.domain.Dentista;
import com.example.Aula22Integradora.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

public class DentistaController {

    @Autowired
    private DentistaService service;

    @GetMapping
    public Map<Integer, Dentista> getDentistas(){

        return service.buscarDentistas();
    }

    @GetMapping("/{id}")
    public Dentista getDentistaId(@PathVariable Integer id){

        return service.buscarDentistaId(id);
    }

    @PostMapping
    public Dentista postDentista(@RequestBody DentistaDAO dao){

        return service.criarDentista(dao);
    }

    @PutMapping
    public Dentista putDentista(@RequestBody DentistaDAO dao){

        return service.editarDentista(dao);
    }

    @DeleteMapping("/{id}")
    public String deleteDentista (@PathVariable Integer id){

        service.deletarDentistaId(id);

        return "Dentista com id " + id +  " foi deletado com sucesso";
    }

}
