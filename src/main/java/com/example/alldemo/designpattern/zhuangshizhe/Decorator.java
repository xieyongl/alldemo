package com.example.alldemo.designpattern.zhuangshizhe;

public class Decorator extends Food{
    //将被装饰者组合进来
    private Food desFood;
    //构造器将其引入
    public Decorator(Food desFood) {
        this.desFood = desFood;
    }
    //将自己的价格与被装饰者价格进行成绩
    @Override
    public double cost() {
        System.out.println(desFood.getDes() +"价格："+desFood.getPrice()+ "配料如下："
                +super.getDes()+"价格："+this.getPrice()+"总价"+(super.getPrice()+desFood.cost()) );
        //价格总计
        return super.getPrice()+desFood.cost();
    }
}
