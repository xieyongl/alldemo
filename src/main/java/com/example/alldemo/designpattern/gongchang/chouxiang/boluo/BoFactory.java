package com.example.alldemo.designpattern.gongchang.chouxiang.boluo;

import com.example.alldemo.designpattern.gongchang.chouxiang.boluo.product.BoComputer;
import com.example.alldemo.designpattern.gongchang.chouxiang.boluo.product.BoPhone;
import com.example.alldemo.designpattern.gongchang.chouxiang.factory.IFactory;
import com.example.alldemo.designpattern.gongchang.chouxiang.factory.product.Computer;
import com.example.alldemo.designpattern.gongchang.chouxiang.factory.product.Phone;

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
