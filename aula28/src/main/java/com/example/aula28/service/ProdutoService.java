package com.example.aula28.service;

import com.example.aula28.persistence.entities.ProdutoEntity;
import com.example.aula28.persistence.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> buscarTodos(){
        return produtoRepository.findAll();
    }
    public ProdutoEntity salvar(ProdutoEntity produtoEntity) {
        return produtoRepository.save(produtoEntity);
        }

    public void deletar(Integer id){
        produtoRepository.deleteById(id);
    }

    public ProdutoEntity editarQtd(Integer id, Integer quantidade){
        //obtendo o produto
        Optional<ProdutoEntity> produto = produtoRepository.findById(id);
        //mudou a qtd mas nao salvou
        produto.get().setQuantidade(produto.get().getQuantidade() - quantidade);
        //salvando o produto
        salvar(produto.get());
        return produto.get();
    }

}



