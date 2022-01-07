package com.example.alldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.example.alldemo.es.controller")
@SpringBootApplication
public class AlldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlldemoApplication.class, args);
    }

}
