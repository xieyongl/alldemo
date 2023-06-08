package com.example.alldemo.designpattern.gongchang.jiandan;

//将Pizza 做成一个接口
public interface Pizza {

    //准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
    void prepare();
}
