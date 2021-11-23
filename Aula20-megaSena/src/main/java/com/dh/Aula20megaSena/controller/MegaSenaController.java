package com.dh.Aula20megaSena.controller;

import com.dh.Aula20megaSena.service.MegaSenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("megasena")
public class MegaSenaController {

    @Autowired
    private MegaSenaService service;

    @GetMapping("criar")
    public List<Integer> criarJogo(){
        return service.criarNumeros();
    }

    @GetMapping("jogos/{qtd}")
    public List<List<Integer>> variosJogos(@PathVariable Integer qtd){
        return service.maisJogos(qtd);
    }
}
