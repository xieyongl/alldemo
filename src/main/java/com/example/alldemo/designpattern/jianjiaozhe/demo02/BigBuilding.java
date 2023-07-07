package com.example.alldemo.designpattern.jianjiaozhe.demo02;

public class BigBuilding extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println("big楼房子开始打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("big楼房子开始建墙了");
    }

    @Override
    public void roofed() {
        System.out.println("big楼房子准备封顶喽");
    }
}
