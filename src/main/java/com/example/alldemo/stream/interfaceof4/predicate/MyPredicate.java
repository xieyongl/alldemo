package com.example.alldemo.stream.interfaceof4.predicate;

import java.util.function.Predicate;

public class MyPredicate<T> implements Predicate<T> {
    @Override
    public boolean test(T t) {
        // 判断如果传入的类型 T 是 String 那么判断是否含有 "J3" 字样
        if (t instanceof String) {
            return ((String) t).contains("J3");
        }
        if (t instanceof Integer) {
            return ((Integer) t) == 18;
        }
        // 如果是 Integer 类型，判断是否等于 18
        return false;
    }
}