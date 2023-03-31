package com.example.alldemo.stream.interfaceof4.function;


import java.util.function.Function;

public class MyFunction<T, R> implements Function<T, R> {
    @Override
    public R apply(T t) {
        System.out.println("处理逻辑....【" + t + "】");
        return null;
    }
}