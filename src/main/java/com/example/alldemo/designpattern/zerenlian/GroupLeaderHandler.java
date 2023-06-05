package com.example.alldemo.designpattern.zerenlian;

public class GroupLeaderHandler extends Handler{

    public GroupLeaderHandler(int daysThreshold){
        this.daysThreshold = daysThreshold;
    }
    @Override
    void pass(String msg, int step) {
        System.out.println("("+step+")组长审批：" + msg);
    }
}

