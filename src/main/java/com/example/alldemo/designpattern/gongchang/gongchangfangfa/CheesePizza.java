package com.example.alldemo.designpattern.gongchang.gongchangfangfa;

//奶酪披萨
public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println(" 给制作奶酪披萨 准备原材料 ");
    }
}