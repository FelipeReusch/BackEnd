package com.example.aula26mesa.repository;

import com.example.aula26mesa.model.Paciente;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PacienteRepository implements IRepository<Paciente>{

    public static Map<Integer, Paciente> pacienteMap = new HashMap<>();

    @Override
    public Map<Integer, Paciente> create(Paciente obj) {
        Integer id = pacienteMap.size() + 1; //adicionar + 1 paciente
        pacienteMap.put(id, obj);

        Map<Integer, Paciente> create = new HashMap<>(); // criar 1 paciente
        create.put(id, pacienteMap.get(id));


        return create;
    }

    @Override
    public Map<Integer, Paciente> update(Paciente obj, Integer id) {
        Paciente updatePaciente = pacienteMap.get(id);
        updatePaciente.setNome(obj.getNome());
        updatePaciente.setEmail(obj.getEmail());

        Map<Integer, Paciente> update = new HashMap<>();
        update.put(id, updatePaciente);

        return update;
    }

    @Override
    public Map<Integer, Paciente> selectAll() {
        return null;
    }

    @Override
    public Map<Integer, Paciente> select(Integer id) {
        Map<Integer, Paciente> select = new HashMap<>();
        select.put(id, pacienteMap.get(id));
        return select;
    }

    @Override
    public void delete(Integer id) {
        pacienteMap.remove(id);
    }
}
