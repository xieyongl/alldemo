package com.example.alldemo.designpattern.zhuangshizhe;

import lombok.Data;

@Data
public abstract class Food {
    private String des;
    private Double price;

    //其他类需要实现的抽象方法
    public abstract double cost();
    //get/set方法省略
}
