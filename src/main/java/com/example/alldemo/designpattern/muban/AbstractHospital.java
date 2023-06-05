package com.example.alldemo.designpattern.muban;

public abstract class AbstractHospital {
    //流程
    public final void procedure() {
        //1、挂号
        this.regiest();
        //2、排队
        this.queue();
        //3、看病
        this.treat();
        //4、取药，有点人不用开药，只是小事
        if(isRecipe()) {
            this.recipe();
        }
    }
    //挂号
    public String regiest() {
        String regiest = "你的订单号为"+((int) (Math.random()*10));
        System.out.println(regiest);
        return regiest;
    }
    //排队
    public void queue() {
        System.out.println("排队中。。。。");
    }
    //看病
    public abstract String  treat();
    //取药
    public abstract String recipe();

    //钩子方法
    boolean isRecipe() {
        return true;
    }
}
