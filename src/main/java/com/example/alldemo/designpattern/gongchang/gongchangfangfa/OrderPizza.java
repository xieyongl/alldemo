package com.example.alldemo.designpattern.gongchang.gongchangfangfa;


public class OrderPizza {

    public static void main(String[] args) {

        //奶酪披萨工厂
        final CheesePizzaFactory cheesePizzaFactory = new CheesePizzaFactory();
        final Pizza pizza = cheesePizzaFactory.createPizza();
        pizza.prepare();

        //希腊披萨工厂
        final GreekPizzaFactory greekPizzaFactory = new GreekPizzaFactory();
        final Pizza pizza1 = greekPizzaFactory.createPizza();
        pizza1.prepare();
    }
}
