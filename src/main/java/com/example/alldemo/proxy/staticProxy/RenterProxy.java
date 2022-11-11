package com.example.alldemo.proxy.staticProxy;

/**
 * @description: TODO 中介类 （代理租客租房）
 * @author: xieyong
 * @date: 2022/6/22 16:37
 **/
public class RenterProxy implements Person{

    private Person person;

    public RenterProxy(Person person) {
        this.person = person;
    }


    @Override
    public void rentHouse() {
        System.out.println("中介找房东租房");
        person.rentHouse();
        System.out.println("中介将房子租给租客");
    }
}