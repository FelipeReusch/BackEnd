package com.example.aula23.service;

import com.example.aula23.dao.ConsultaDAO;
import com.example.aula23.model.Consulta;
import com.example.aula23.model.Dentista;
import com.example.aula23.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@Service
public class ConsultaService {

    private DentistaService dentistaService;
    private PacienteService pacienteService;

    private static Map<Integer, Consulta> mapConsulta = new HashMap<>();



    public Map<Integer, Consulta> buscarConsultas(){
        return mapConsulta;
    }

    public void deletarConsulta(Integer id){
        mapConsulta.remove(id);
    }

    public Consulta criarConsulta(ConsultaDAO dao){
        if (!dentistaService.dentistaMap.containsKey(dao.getDentista().getMatricula()) ||
        !dentistaService.dentistaMap.containsKey(dao.getPaciente().getEmail())){
            return null;
        }
        Integer id = mapConsulta.size() + 1;

        mapConsulta.put(id, new Consulta(dao.getPaciente(), dao.getDentista(), dao.getDataDaConsulta()));

        return mapConsulta.get(id);
    }

    public Consulta editarConsulta(ConsultaDAO dao){

        Consulta consulta = mapConsulta.get(dao.getId());

        consulta.setDataDaConsulta(dao.getDataDaConsulta());

        return consulta;
    }


}
