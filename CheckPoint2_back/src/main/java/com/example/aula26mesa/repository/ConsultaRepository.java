package com.example.aula26mesa.repository;

import com.example.aula26mesa.model.Consulta;
import com.example.aula26mesa.model.Paciente;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ConsultaRepository implements IRepository<Consulta> {

    public static Map<Integer, Consulta> consultaMap = new HashMap<>();

    @Override
    public Map<Integer, Consulta> create(Consulta obj) {
        Integer id = consultaMap.size() + 1; //adicionar + 1 consulta
        consultaMap.put(id, obj);

        Map<Integer, Consulta> create = new HashMap<>(); // criar 1 consulta
        create.put(id, consultaMap.get(id));


        return create;
    }

    @Override
    public Map<Integer, Consulta> update(Consulta obj, Integer id) {
        Consulta updateConsulta = consultaMap.get(id);
        updateConsulta.setPaciente(obj.getPaciente());
        updateConsulta.setDentista(obj.getDentista());

        Map<Integer, Consulta> update = new HashMap<>();
        update.put(id, updateConsulta);

        return update;
    }

    @Override
    public Map<Integer, Consulta> selectAll() {
        return null;
    }

    @Override
    public Map<Integer, Consulta> select(Integer id) {
        Map<Integer, Consulta> select = new HashMap<>();
        select.put(id, consultaMap.get(id));
        return select;
    }

    @Override
    public void delete(Integer id) {
        consultaMap.remove(id);
    }
}
