package com.example.aula26mesa.service;

import com.example.aula26mesa.dao.PacienteDAO;
import com.example.aula26mesa.model.Paciente;
import com.example.aula26mesa.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository; // chamar Repository

    public Map<Integer, Paciente> buscarPaciente(){
        return repository.selectAll();
    }

    public Map<Integer, Paciente> buscarPacientePorId(Integer id){
        return repository.select(id);
    }


    public String deletarPaciente(Integer id){
        repository.delete(id);
        return  "Deletado com sucesso";
    }

    public Map<Integer, Paciente> criarPaciente(PacienteDAO dao){
        Paciente paciente = new Paciente(dao.getNome(), dao.getSobrenome(), dao.getEmail(), dao.getIdade());

        return repository.create(paciente);
    }

    public Map<Integer, Paciente> editarPaciente(PacienteDAO dao){
        Paciente paciente = new Paciente(dao.getNome(), dao.getSobrenome(), dao.getEmail(), dao.getIdade());

        return repository.update(paciente, dao.getId());
    }
}
