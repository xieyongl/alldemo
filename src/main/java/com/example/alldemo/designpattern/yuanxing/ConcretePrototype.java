package com.example.alldemo.designpattern.yuanxing;

import lombok.Data;

//写一个手机的克隆类
@Data
public class ConcretePrototype implements Cloneable{
    //名称
    private String name;
    //号码
    private Long number;
    //构造器
    public ConcretePrototype(String name, Long number) {
        super();
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "ConcretePrototype [name=" + name + ", number=" + number + "]";
    }
    // 克隆用到的主要部分
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ConcretePrototype ConcretePrototype = null;
        try {
            /** 这里就是调用的 Object 类的 clone 方法 **/
            ConcretePrototype = (ConcretePrototype) super.clone();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ConcretePrototype;
    }
}
