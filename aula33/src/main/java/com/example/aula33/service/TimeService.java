package com.example.aula33.service;


import com.example.aula33.modal.Time;
import com.example.aula33.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public Time createTime(Time time){
        return repository.save(time);

    }
}
