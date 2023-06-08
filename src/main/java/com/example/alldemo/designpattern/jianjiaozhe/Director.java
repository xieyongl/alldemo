package com.example.alldemo.designpattern.jianjiaozhe;

public class Director {
    //需要将抽象类聚合进来
    Builder builder = null;
    //创建一个构造器 调用时传入具体的实现类
    public Director(Builder builder) {
        this.builder = builder;
    }
    //添加set 方法 用户可以通过此方法修改已有的 建造者对象
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    //笔记本的组成流程  返回的是产品类
    public Product pack_pc() {
        builder.buildMainboard();
        builder.buildCpu();
        builder.buildMemory();
        return builder.getResult();
    }
}
