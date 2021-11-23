package com.example.aula26mesa.service;

import com.example.aula26mesa.dao.ConsultaDAO;
import com.example.aula26mesa.dao.PacienteDAO;
import com.example.aula26mesa.model.Consulta;
import com.example.aula26mesa.model.Paciente;
import com.example.aula26mesa.repository.ConsultaRepository;
import com.example.aula26mesa.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository; // chamar Repository

    public Map<Integer, Consulta> buscarConsulta(){
        return repository.selectAll();
    }

    public Map<Integer, Consulta> buscarConsultaPorId(Integer id){
        return repository.select(id);
    }


    public String deletarConsulta(Integer id){
        repository.delete(id);
        return  "Deletado com sucesso";
    }

    public Map<Integer, Consulta> criarConsulta(ConsultaDAO dao){
        Consulta consulta = new Consulta(dao.getPaciente(), dao.getDentista(), dao.getDataDaConsulta());

        return repository.create(consulta);
    }

    public Map<Integer, Consulta> editarConsulta(ConsultaDAO dao){
        Consulta consulta = new Consulta(dao.getPaciente(), dao.getDentista(), dao.getDataDaConsulta());

        return repository.update(consulta, dao.getId());
    }
}
