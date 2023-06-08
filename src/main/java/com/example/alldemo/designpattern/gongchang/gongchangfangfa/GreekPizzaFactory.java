package com.example.alldemo.designpattern.gongchang.gongchangfangfa;


public class GreekPizzaFactory implements PizzaFactory{

    @Override
    public Pizza createPizza() {
        Pizza greekPizze= new GreekPizza();
        return greekPizze;
    }
}