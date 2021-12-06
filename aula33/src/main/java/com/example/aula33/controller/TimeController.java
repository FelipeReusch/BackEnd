package com.example.aula33.controller;

import com.example.aula33.modal.Time;
import com.example.aula33.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    /** criando Time */
    @PostMapping
    public Time postTime(@RequestBody Time time){
        return timeService.createTime(time);
    }
}

