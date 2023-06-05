package com.example.alldemo.designpattern.zerenlian;

public abstract class Handler {

    //天数阈值
    protected int daysThreshold;


    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void leaveHandler(int days, String msg,int step){
        if(days >= this.daysThreshold){
            pass(msg, step++);
        }

        if(nextHandler != null){
            nextHandler.leaveHandler(days,msg, step);
        }
    }

    abstract void pass(String msg, int step);

}

