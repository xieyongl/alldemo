package com.example.alldemo.stream.interfaceof4.supplier;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> stringSupp = () ->{
            // 你的逻辑
            return "调用get方法，我才给你数据";
        };
        System.out.println(stringSupp.get());
    }
}