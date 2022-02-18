package com.example.alldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan("com.example.alldemo.*")
@SpringBootApplication
@EnableAsync
public class AlldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlldemoApplication.class, args);
    }

}
