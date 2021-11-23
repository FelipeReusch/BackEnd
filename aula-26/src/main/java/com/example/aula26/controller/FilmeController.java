package com.example.aula26.controller;

import com.example.aula26.dao.FilmeDAO;
import com.example.aula26.model.Filme;
import com.example.aula26.service.ServiceFilme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FilmeController {

    @Autowired
    private ServiceFilme service;

    @GetMapping
    public ResponseEntity<Map<Integer, Filme>> getAllFilmes(){
        return ResponseEntity.ok(service.buscarFilme());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<Integer, Filme>> getFilme(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarFilmePorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilme(@PathVariable Integer id){
        return ResponseEntity.ok(service.deletarFilme(id));
    }

    @PostMapping
    public ResponseEntity<Map<Integer, Filme>> postFilme(@RequestBody FilmeDAO dao){
        return ResponseEntity.ok(service.criarFilme(dao));
    }

    @PutMapping
    public ResponseEntity <Map<Integer, Filme>> putFilme(@RequestBody FilmeDAO dao){
        return ResponseEntity.ok(service.editarFilme(dao));
    }
}
