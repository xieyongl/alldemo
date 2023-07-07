package com.example.alldemo.designpattern.zhuangshizhe;

public class Noodles extends Food{
    //这里获取到的价格是子类实现时设置的价格
    @Override
    public double cost() {
        return super.getPrice();
    }
}
