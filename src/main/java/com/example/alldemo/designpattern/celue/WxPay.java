package com.example.alldemo.designpattern.celue;

import java.math.BigDecimal;

public class WxPay implements Pay {

    @Override
    public void pay(BigDecimal money) {
        System.out.println("使用微信成功支付" + money +"元...");
    }
}