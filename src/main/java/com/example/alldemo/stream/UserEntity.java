package com.example.alldemo.stream;

import lombok.Data;
@Data
public class UserEntity {

    private String name;
    private int age;

    public UserEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
