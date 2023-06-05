package com.example.alldemo.designpattern.celue;

import java.math.BigDecimal;

public class ZfbPay implements Pay{

    @Override
    public void pay(BigDecimal money) {
        System.out.println("使用支付宝成功支付" + money + "元...");
    }
}