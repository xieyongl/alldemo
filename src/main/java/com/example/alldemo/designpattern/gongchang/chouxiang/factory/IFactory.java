package com.example.alldemo.designpattern.gongchang.chouxiang.factory;

import com.example.alldemo.designpattern.gongchang.chouxiang.factory.product.Computer;
import com.example.alldemo.designpattern.gongchang.chouxiang.factory.product.Phone;

/**
 * 抽象工厂 - 工厂的工厂
 */
public interface IFactory {

    //创建手机
    Phone createPhone();

    //创建电脑
    Computer createComputer();


}