package com.example.alldemo.utils;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @description: TODO 获取执行时间
 * @author: xieyong
 * @date: 2022/7/1 18:06
 **/
public class Demo {

//    public static void main(String[] args) {
//
//        Stopwatch started = Stopwatch.createStarted();
//        for(int i=0; i<100000; i++) {
//            System.out.println(i);
//        }
//        System.out.println("耗时：" + started.elapsed(TimeUnit.MILLISECONDS));
//    }

    public static void main(String[] args) {

        System.out.println("消费型接口");
        happy(1000, (x) -> System.out.println("消费" + x));

        System.out.println("供给型接口");
        List<Integer> l = getNumList(10, () -> (int) (Math.random() * 10));
        l.forEach(System.out::println);

        System.out.println("函数型接口");
        String str = strHead("\t\t啊哈哈哈", (x) -> x.trim());
        System.out.println(str);

        System.out.println("断言型接口");
        List<String> list = Arrays.asList("Bobaaa", "Tag", "Lion", "Hah");
        List<String> s = filterStr(list, (x) -> x.length() > 3);
        s.forEach(System.out::println);

    }

    //返回输入的信息 消费型接口
    public static void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //创建指定个数的集合 供给型接口
    public static List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int n = sup.get();
            list.add(n);
        }
        return list;
    }

    //Function<T, R>函数型接口
    public static String strHead(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    //将满足条件的字符串放入集合中(条件由lambda体操作) 断言型接口
    public static List<String> filterStr(List<String> list, Predicate<String> str) {
        List<String> stringList = new ArrayList<>();
        for (String s : list) {
            if (str.test(s)) {
                stringList.add(s);
            }
        }
        return stringList;
    }

}