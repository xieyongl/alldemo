package com.example.alldemo.proxy.staticProxy;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/6/22 16:35
 **/
public class Renter implements Person{

    @Override
    public void rentHouse() {
        System.out.println("租客租房成功！");
    }
}