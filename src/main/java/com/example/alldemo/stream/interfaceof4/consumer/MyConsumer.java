package com.example.alldemo.stream.interfaceof4.consumer;


import java.util.function.Consumer;

public class MyConsumer<T> implements Consumer<T> {

    @Override
    public void accept(T t) {
        // 自己的处理逻辑
        System.out.println("======开始做一下事情，对传入的 T======");
        System.out.println("正在对 T(" + t + ") 做事情...");
        System.out.println("======end======");
    }
}