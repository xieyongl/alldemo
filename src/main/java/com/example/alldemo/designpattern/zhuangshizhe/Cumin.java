package com.example.alldemo.designpattern.zhuangshizhe;

//孜然类
public class Cumin extends Decorator{
    //构造器
    public Cumin(Food desFood) {
        super(desFood);
        setDes("孜然");
        setPrice(2.00);
    }
}
