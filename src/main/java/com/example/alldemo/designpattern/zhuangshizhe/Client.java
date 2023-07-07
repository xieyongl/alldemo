package com.example.alldemo.designpattern.zhuangshizhe;

public class Client {
    public static void main(String[] args) {
        //先定义一个被装饰者,返回对象要为最顶层的对象，这样被装饰者才能接受
        Food noodles = new ChineseNoodles();
        //定义一个装饰者对象
        Food cumin = new Cumin(noodles);
        //输出为：中式面条价格：25.0配料如下：孜然价格：2.0
        cumin.cost();

//        //再定义一个装饰者 Pepper辣椒类
//        Food pepper = new Pepper(cumin);
//        //输出为：中式面条价格：25.0配料如下：孜然价格：2.0配料如下：辣椒价格：1.0总价28.0
//        pepper.cost();
    }
}
