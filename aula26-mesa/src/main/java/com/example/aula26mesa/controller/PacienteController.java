package com.example.aula26mesa.controller;

import com.example.aula26mesa.dao.PacienteDAO;
import com.example.aula26mesa.model.Paciente;
import com.example.aula26mesa.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<Map<Integer, Paciente>> getAllPacientes(){
        return ResponseEntity.ok(service.buscarPaciente());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<Integer, Paciente>> getPacientes(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarPacientePorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Integer id){
        return ResponseEntity.ok(service.deletarPaciente(id));
    }

    @PostMapping
    public ResponseEntity<Map<Integer, Paciente>> postPaciente(@RequestBody PacienteDAO dao){
        return ResponseEntity.ok(service.criarPaciente(dao));
    }

    @PutMapping
    public ResponseEntity <Map<Integer, Paciente>> putPaciente(@RequestBody PacienteDAO dao){
        return ResponseEntity.ok(service.editarPaciente(dao));
    }
}
