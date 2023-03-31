package com.example.alldemo.stream.interfaceof4.supplier;

import java.util.function.Supplier;

public class MySupplier<T> implements Supplier<T> {
    @Override
    public T get() {
        // 我将提供一个指定 T 类型数据出去
        // 这里的 T 我先内定为 MySupplier 类型进行编写案例
        MySupplier<T> t = new MySupplier<>();
        return (T) t;
    }
}