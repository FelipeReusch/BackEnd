package com.example.aula26.repository;

import java.util.Map;

// CRUD - interface
public interface IRepository <M> {

    Map<Integer, M> create (M obj);
    Map<Integer, M> update (M obj, Integer id);
    Map<Integer, M> selectAll ();
    Map<Integer, M> select (Integer id);
    void delete (Integer id);

}
