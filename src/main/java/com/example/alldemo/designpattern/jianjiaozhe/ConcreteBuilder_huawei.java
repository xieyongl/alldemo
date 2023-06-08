package com.example.alldemo.designpattern.jianjiaozhe;

public class ConcreteBuilder_huawei extends Builder{

    @Override
    public void buildCpu() {
        product.setCPU("华为CPU");
    }

    @Override
    public void buildMainboard() {
        product.setMainboard("华为主板");
    }

    @Override
    public void buildMemory() {
        product.setMemory("华为内存");
    }

}
