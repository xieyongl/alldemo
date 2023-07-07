package com.example.alldemo.designpattern.jianjiaozhe.demo02;

public class Client {

    public static void main(String[] args) {

        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector();

        //盖高楼
        HighBuilding highBuilding = new HighBuilding();
        //重置建造者
        houseDirector.setHouseBuilder(highBuilding);
        //完成盖房子，返回产品(高楼)
        houseDirector.constructorHouse();


        //盖big楼
        BigBuilding bigBuilding = new BigBuilding();
        //重置建造者
        houseDirector.setHouseBuilder(bigBuilding);
        //完成盖房子，返回产品(高楼)
        houseDirector.constructorHouse();

    }
}
