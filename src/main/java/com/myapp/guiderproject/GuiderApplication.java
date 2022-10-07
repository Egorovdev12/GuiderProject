package com.myapp.guiderproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuiderApplication.class, args);
    }
}


//TODO EXCEPTIONS причём желательно Advice - доделать на put и delete, сделать так, чтобы возвращася JSON вместо String
//TODO и понять почему message не прходит из сервиса
//TODO Валидация