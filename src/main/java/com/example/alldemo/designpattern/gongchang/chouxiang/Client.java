package com.example.alldemo.designpattern.gongchang.chouxiang;

public class Client {
    public static void main(String[] args) {

        IFactory liFactory = new LiFactory();
        IFactory boFactory = new BoFactory();

        //创建梨子手机
        Phone phoneA = liFactory.createPhone();
        //创建菠萝手机
        Phone phoneB = boFactory.createPhone();

        //创建梨子电脑
        Computer computerA = liFactory.createComputer();
        //创建菠萝电脑
        Computer computerB = boFactory.createComputer();

        phoneA.showPhone();
        phoneB.showPhone();
        computerA.showComputer();
        computerB.showComputer();
    }
}