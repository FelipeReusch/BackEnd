package com.example.aula36.controller;

import com.example.aula36.exception.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {

    @GetMapping("/{num}")
    public String validarCalculo(@PathVariable String num) throws BadRequestException {

        try {
            Integer i = Integer.valueOf(num) * 2;
            return "É UM NUMERO";
        } catch (Exception e) {
            throw new BadRequestException("NAO É UM NUMERO");

        }
    }
}
