package com.example.alldemo.designpattern.jianjiaozhe;

public abstract class Builder {
    //组合 产品对象
    protected Product product = new Product();

    //抽象方法
    public abstract void buildCpu();
    public abstract void buildMainboard();
    public abstract void buildMemory();

    //返回一个产品对象
    public Product getResult() {
        return product;
    }
}
