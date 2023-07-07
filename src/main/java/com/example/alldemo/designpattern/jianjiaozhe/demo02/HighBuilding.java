package com.example.alldemo.designpattern.jianjiaozhe.demo02;

public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼房子开始打地基");
    }
    @Override
    public void buildWalls() {
        System.out.println("高楼房子开始建墙了");
    }
    @Override
    public void roofed() {
        System.out.println("高楼房子准备封顶喽");
    }
}
