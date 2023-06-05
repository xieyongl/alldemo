package com.example.alldemo.designpattern.celue;


import java.math.BigDecimal;

public class PayStrategyService {

    private Pay pay;

    public PayStrategyService(Pay pay) {
        this.pay = pay;
    }


    public void payment(BigDecimal money) {
        pay.pay(money);
    }

}