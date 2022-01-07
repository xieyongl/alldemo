package com.example.alldemo.es.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/1/7 18:05
 **/
@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}