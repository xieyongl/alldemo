package com.example.alldemo.designpattern.gongchang.jiandan;

public class SimpleFactory {

    //传入 orderType（种类） 返回对应的 Pizza 对象
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;
        //使用简单工厂模式
        if (orderType.equals("greek")) {
            //希腊披萨
            pizza = new GreekPizza();
        } else if (orderType.equals("cheese")) {
            //奶酪披萨
            pizza = new CheesePizza();
        }
        return pizza;
    }
}
