package com.example.aula33.modal;

import com.example.aula33.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Optional;

@Document(collection = "partida")
@Getter
@Setter
public class Partida {

    @Id
    private String id;
    private Status status;
    private String resultado;
    @Field (name = "time-local")
    private Time timeLocal;
    @Field (name = "time-visitante")
    private Time  timeVisitante;

}
