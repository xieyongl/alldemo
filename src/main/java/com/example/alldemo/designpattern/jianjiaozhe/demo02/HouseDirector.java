package com.example.alldemo.designpattern.jianjiaozhe.demo02;

public class HouseDirector {
    HouseBuilder houseBuilder = null;
    //空参构造器
    public HouseDirector() {
    }
    //通过setter传入houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    //如何处理建造房子的流程，交给指挥者
    public House constructorHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
