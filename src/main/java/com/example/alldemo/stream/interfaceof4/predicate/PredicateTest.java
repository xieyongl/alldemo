package com.example.alldemo.stream.interfaceof4.predicate;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        //基础方式一：
        MyPredicate<String> stringMyPredicate = new MyPredicate<>();
        System.out.println(stringMyPredicate.test("J3-白起"));
        System.out.println(stringMyPredicate.test("白起"));

        MyPredicate<Integer> integerMyPredicate = new MyPredicate<>();
        System.out.println(integerMyPredicate.test(18));
        System.out.println(integerMyPredicate.test(28));

        //进阶方式二：
        Predicate<String> myStringPredicate = (t) -> t.contains("J3");
        System.out.println(myStringPredicate.test("J3-白起"));
        System.out.println(myStringPredicate.test("白起"));

        Predicate<Integer> myIntegerPredicate = (t) -> t == 18;
        System.out.println(myIntegerPredicate.test(18));
        System.out.println(myIntegerPredicate.test(28));
    }
}