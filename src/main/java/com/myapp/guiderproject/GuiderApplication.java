package com.myapp.guiderproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuiderApplication.class, args);
    }
}

//TODO улучшить логику через save(entity) в сервисах