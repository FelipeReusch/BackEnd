package com.example.aula28.persistence.repository;

import com.example.aula28.persistence.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoEntity, Integer> {

}
