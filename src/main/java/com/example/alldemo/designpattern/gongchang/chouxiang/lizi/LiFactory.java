package com.example.alldemo.designpattern.gongchang.chouxiang.lizi;

import com.example.alldemo.designpattern.gongchang.chouxiang.factory.IFactory;
import com.example.alldemo.designpattern.gongchang.chouxiang.factory.product.Computer;
import com.example.alldemo.designpattern.gongchang.chouxiang.factory.product.Phone;
import com.example.alldemo.designpattern.gongchang.chouxiang.lizi.product.LiComputer;
import com.example.alldemo.designpattern.gongchang.chouxiang.lizi.product.LiPhone;

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
