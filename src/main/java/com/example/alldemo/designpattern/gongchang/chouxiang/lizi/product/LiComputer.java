package com.example.alldemo.designpattern.gongchang.chouxiang.lizi.product;

import com.example.alldemo.designpattern.gongchang.chouxiang.factory.product.Computer;

public class LiComputer implements Computer {
    @Override
    public void showComputer() {
        System.out.println("我是梨子电脑");
    }
}