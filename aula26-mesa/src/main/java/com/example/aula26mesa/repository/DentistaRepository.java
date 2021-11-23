package com.example.aula26mesa.repository;

import com.example.aula26mesa.model.Dentista;
import com.example.aula26mesa.model.Paciente;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DentistaRepository implements IRepository<Dentista> {

    public static Map<Integer, Dentista > dentistaMap = new HashMap<>();

    @Override
    public Map<Integer, Dentista> create(Dentista obj) {
        Integer id = dentistaMap.size() + 1; //adicionar + 1 dentista
        dentistaMap.put(id, obj);

        Map<Integer, Dentista> create = new HashMap<>(); // criar 1 dentista
        create.put(id, dentistaMap.get(id));


        return create;
    }

    @Override
    public Map<Integer, Dentista> update(Dentista obj, Integer id) {
        Dentista updateDentista = dentistaMap.get(id);
        updateDentista.setNome(obj.getNome());
        updateDentista.setMatricula(obj.getMatricula());

        Map<Integer, Dentista> update = new HashMap<>();
        update.put(id, updateDentista);

        return update;
    }

    @Override
    public Map<Integer, Dentista> selectAll() {
        return null;
    }

    @Override
    public Map<Integer, Dentista> select(Integer id) {
        Map<Integer, Dentista> select = new HashMap<>();
        select.put(id, dentistaMap.get(id));
        return select;
    }

    @Override
    public void delete(Integer id) {
        dentistaMap.remove(id);
    }
}
