package com.example.alldemo.designpattern.gongchang.chouxiang.boluo.product;

import com.example.alldemo.designpattern.gongchang.chouxiang.factory.product.Phone;

public class BoPhone implements Phone {
    @Override
    public void showPhone(){
        System.out.println("我是菠萝手机");
    }
}