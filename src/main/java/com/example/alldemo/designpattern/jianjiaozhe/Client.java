package com.example.alldemo.designpattern.jianjiaozhe;

/**
 * 指挥者(director) 用 构造器(builder) 去 创建目标对象(product)
 */

public class Client {

    public static void main(String[] args) {
        //创建需要的电脑子部件——例如我们要组装的是 华为
        ConcreteBuilder_huawei huawei = new ConcreteBuilder_huawei();

        //调用指挥者类，将需要的品牌传入，根据控制着中的流程进行组装
        Director director = new Director(huawei);

        //调用组装方法，返回产品
        Product pack_pc = director.pack_pc();

        //查看输入的结果
        System.out.println(pack_pc.toString());
        //结果为：Product [CPU=华为CPU, mainboard=华为主板, memory=华为内存]

    }
}
