package com.example.alldemo.designpattern.yuanxing;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建一个对象
        ConcretePrototype prototype = new ConcretePrototype("华为", new Long(1568889932));
        //通过原型模式完成对象的创建  克隆
        ConcretePrototype p2 = (ConcretePrototype)prototype.clone();
        System.out.println("克隆的对象：" + p2.toString());

        p2.setName("克隆的");
        p2.setNumber(110L);
        System.out.println(prototype.toString());
        System.out.println(p2.toString());
    }
}
