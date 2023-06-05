package com.example.alldemo.designpattern.zerenlian;

public class DeptLeaderHandler extends Handler{

    public DeptLeaderHandler(int daysThreshold){
        this.daysThreshold = daysThreshold;
    }
    @Override
    void pass(String msg, int step) {
        System.out.println("("+step+")部门领导审批：" + msg);
    }
}
