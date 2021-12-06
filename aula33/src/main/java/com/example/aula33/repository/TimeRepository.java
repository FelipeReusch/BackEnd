package com.example.aula33.repository;


import com.example.aula33.modal.Time;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  TimeRepository extends MongoRepository<Time, String> {
}
