package com.example.alldemo.designpattern.gongchang.chouxiang;

public class LiFactory implements IFactory {
    @Override
    public Phone createPhone() {
        Phone phone =  new LiPhone();
        // .....
        //  初始化代码
        return phone;
    }

    @Override
    public Computer createComputer() {
        Computer computer =  new LiComputer();
        // .....
        // 初始化代码
        return computer;
    }
}
