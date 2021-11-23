package com.dh.Aula20megaSena.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MegaSenaService {
    //metodo criar
    public List<Integer> criarNumeros(){
        List<Integer> numerosSorteados = new ArrayList<>();
        Random random = new Random();
        while (numerosSorteados.size()<6) {
            numerosSorteados.add(random.nextInt(1, 60));
        }
        return numerosSorteados;
    }

    //metodo mais jogos
    public List<List<Integer>> maisJogos(Integer qtd){
        List<List<Integer>> variosJogos = new ArrayList<>();
        int iniciador = 0;


        while (qtd>iniciador){
            variosJogos.add(criarNumeros());
            iniciador++;
        }
        return variosJogos;
    }
}
