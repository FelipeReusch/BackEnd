package com.dh.Aula21.controller;

import com.dh.Aula21.dao.PokemonDAO;
import com.dh.Aula21.domain.Pokemon;
import com.dh.Aula21.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired //pegar a pasta service
    private PokemonService service;

    @GetMapping //buscar a lista
    public Map<Integer, Pokemon> getPokemon(){
        return service.buscarPokemon();
    }

    @PostMapping // criar
    public Pokemon postPokemon(@RequestBody PokemonDAO dao) {
        return service.criarPokemon(dao);
    }

    @PutMapping // editar
    public Pokemon putPokemon(@RequestBody PokemonDAO dao){
        return service.editarPokemon(dao);
    }


}
