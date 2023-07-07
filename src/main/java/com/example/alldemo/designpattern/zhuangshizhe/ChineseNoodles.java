package com.example.alldemo.designpattern.zhuangshizhe;

public class ChineseNoodles extends Noodles{
    //构造器中只需要定义该产品的价格和描述，因为它是被装饰者，与平常类一样
    public ChineseNoodles() {
        setDes("中式面条");
        setPrice(25.00);
    }
}
