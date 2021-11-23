package com.example.aula28.controller;

import com.example.aula28.persistence.entities.ProdutoEntity;
import com.example.aula28.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>>getTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> postProduto(@RequestBody ProdutoEntity produtoEntity){
        return ResponseEntity.ok(service.salvar(produtoEntity));
    }

    @PutMapping("{id}/{qtd}")
    public ResponseEntity<ProdutoEntity> putProduto(@PathVariable Integer id, @PathVariable Integer quantidade) {
        return ResponseEntity.ok(service.editarQtd(id, quantidade));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.ok("Produto deletado com sucesso");
    }

}
