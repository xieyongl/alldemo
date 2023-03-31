package com.example.alldemo.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionDemo01 {

    @SneakyThrows
    public static void main(String[] args) {

        Class clz = Class.forName("java.util.ArrayList");
        Method method_add = clz.getMethod("add",Object.class);
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        method_add.invoke(object, "reflection");

        Method method_get = clz.getMethod("get",int.class);
        System.out.println(method_get.invoke(object, 0));
    }
}