package com.example.alldemo.designpattern.gongchang.gongchangfangfa;


public class CheesePizzaFactory implements PizzaFactory {

    @Override
    public Pizza createPizza() {
        Pizza cheesePizza = new CheesePizza();
        return cheesePizza;
    }
}