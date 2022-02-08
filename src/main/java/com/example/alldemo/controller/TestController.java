package com.example.alldemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/7 14:50
 **/
@RestController("/test")
public class TestController {


    @GetMapping("/hello")
    public String hello() {
        return "hello-world!";
    }


}