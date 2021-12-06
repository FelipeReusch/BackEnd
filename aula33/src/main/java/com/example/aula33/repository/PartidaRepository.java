package com.example.aula33.repository;

import com.example.aula33.modal.Partida;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartidaRepository extends MongoRepository <Partida, String> {
}
