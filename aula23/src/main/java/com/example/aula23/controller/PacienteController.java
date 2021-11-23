package com.example.aula23.controller;

import com.example.aula23.dao.DentistaDAO;
import com.example.aula23.dao.PacienteDAO;
import com.example.aula23.model.Dentista;
import com.example.aula23.model.Paciente;
import com.example.aula23.service.DentistaService;
import com.example.aula23.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("paciente")

public class PacienteController {
    @Autowired
    private PacienteService service;

    @GetMapping //buscar a lista
    public Map<Integer, Paciente> getPaciente(){
        return service.buscarPaciente();
    }

    @GetMapping("/{id}")
    public Paciente getPacienteId(@PathVariable Integer id){

        return service.buscarPacienteId(id);
    }

    @PostMapping // criar
    public Paciente postPaciente(@RequestBody PacienteDAO dao) {
        return service.criarPaciente(dao);
    }

    @PutMapping // editar
    public Paciente putPaciente(@RequestBody PacienteDAO  dao){
        return service.editarPaciente(dao);
    }

    @DeleteMapping("/{id}")
    public String deletePaciente (@PathVariable Integer id){

        service.deletarPacienteId(id);

        return "Dentista com id " + id +  " foi deletado com sucesso";
    }

}
