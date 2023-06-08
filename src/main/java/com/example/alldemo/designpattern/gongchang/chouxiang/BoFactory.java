package com.example.alldemo.designpattern.gongchang.chouxiang;

public class BoFactory implements IFactory {
    @Override
    public Phone createPhone() {
        Phone phone =  new BoPhone();
        // .....
        //  初始化代码
        return phone;
    }

    @Override
    public Computer createComputer() {
        Computer computer =  new BoComputer();
        // .....
        // 初始化代码
        return computer;
    }
}
