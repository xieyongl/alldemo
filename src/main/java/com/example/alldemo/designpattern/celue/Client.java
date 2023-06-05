package com.example.alldemo.designpattern.celue;

import java.math.BigDecimal;

public class Client {

    public static void main(String[] args) {

        PayStrategyService payStrategy1 = new PayStrategyService(new WxPay());
        payStrategy1.payment(new BigDecimal("12.88"));
        PayStrategyService payStrategy2 = new PayStrategyService(new ZfbPay());
        payStrategy2.payment(new BigDecimal("22.88"));


    }
}