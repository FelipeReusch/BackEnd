package com.example.aula26mesa.controller;

import com.example.aula26mesa.dao.DentistaDAO;
import com.example.aula26mesa.dao.PacienteDAO;
import com.example.aula26mesa.model.Dentista;
import com.example.aula26mesa.model.Paciente;
import com.example.aula26mesa.service.DentistaService;
import com.example.aula26mesa.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("dentista")
public class DentistaController {
    @Autowired
    private DentistaService service;

    @GetMapping
    public ResponseEntity<Map<Integer, Dentista>> getAllDentistas(){
        return ResponseEntity.ok(service.buscarDentista());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<Integer, Dentista>> getDentistas(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarDentistaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDentista(@PathVariable Integer id){
        return ResponseEntity.ok(service.deletarDentista(id));
    }

    @PostMapping
    public ResponseEntity<Map<Integer, Dentista>> postDentista(@RequestBody DentistaDAO dao){
        return ResponseEntity.ok(service.criarDentista(dao));
    }

    @PutMapping
    public ResponseEntity <Map<Integer, Dentista>> putDentista(@RequestBody DentistaDAO dao){
        return ResponseEntity.ok(service.editarDentista(dao));
    }
}
