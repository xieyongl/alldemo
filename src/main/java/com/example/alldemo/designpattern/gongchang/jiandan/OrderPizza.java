package com.example.alldemo.designpattern.gongchang.jiandan;

public class OrderPizza {

    //定义用户要获取的披萨类型
    private static final String pizza = "greek";

    public static void main(String[] args) {

        //通过工厂获取希腊披萨
        SimpleFactory simpleFactory = new SimpleFactory();

        //greekPizza 就是我们需要获取的目标披萨
        Pizza greekPizza = simpleFactory.createPizza(pizza);

        //调用目标披萨的方法
        greekPizza.prepare();
    }
}
