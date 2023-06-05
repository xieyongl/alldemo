package com.example.alldemo.designpattern.zerenlian;

public class VPHandler extends Handler{

    public VPHandler(int daysThreshold){
        this.daysThreshold = daysThreshold;
    }
    @Override
    void pass(String msg, int step) {
        System.out.println("("+step+")大大领导VP审批：" + msg);
    }
}
