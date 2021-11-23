package com.example.aula26mesa.controller;

import com.example.aula26mesa.dao.ConsultaDAO;
import com.example.aula26mesa.model.Consulta;
import com.example.aula26mesa.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @GetMapping
    public ResponseEntity<Map<Integer, Consulta>> getAllConsultas(){
        return ResponseEntity.ok(service.buscarConsulta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<Integer, Consulta>> getConsultas(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarConsultaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsulta(@PathVariable Integer id){
        return ResponseEntity.ok(service.deletarConsulta(id));
    }

    @PostMapping
    public ResponseEntity<Map<Integer, Consulta>> postConsulta(@RequestBody ConsultaDAO dao){
        return ResponseEntity.ok(service.criarConsulta(dao));
    }

    @PutMapping
    public ResponseEntity <Map<Integer, Consulta>> putConsulta(@RequestBody ConsultaDAO dao){
        return ResponseEntity.ok(service.editarConsulta(dao));
    }
}
