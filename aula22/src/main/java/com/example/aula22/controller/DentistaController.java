package com.example.aula22.controller;

import com.example.aula22.dao.DentistaDAO;
import com.example.aula22.domain.Dentista;
import com.example.aula22.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("dentista")
public class DentistaController {

    @Autowired
    private DentistaService service;

    @GetMapping //buscar a lista
    public Map<Integer, Dentista> getDentista(){
        return service.buscarDentista();
    }

    @GetMapping("/{id}")
    public Dentista getDentistaId(@PathVariable Integer id){

        return service.buscarDentistaId(id);
    }

    @PostMapping // criar
    public Dentista postDentista(@RequestBody DentistaDAO dao) {
        return service.criarDentista(dao);
    }

    @PutMapping // editar
    public Dentista putDentista(@RequestBody DentistaDAO dao){
        return service.editarDentista(dao);
    }

    @DeleteMapping("/{id}")
    public String deleteDentista (@PathVariable Integer id){

        service.deletarDentistaId(id);

        return "Dentista com id " + id +  " foi deletado com sucesso";
    }

}
