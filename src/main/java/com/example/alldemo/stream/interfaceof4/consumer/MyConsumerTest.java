package com.example.alldemo.stream.interfaceof4.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MyConsumerTest {

    public static void main(String[] args) {

        //基础方式一：

//        MyConsumer<String> stringMyConsumer = new MyConsumer<>();
//        List<String> stringList1 = Arrays.asList("a", "b", "c", "d");
//        // 遍历
//        for (String s : stringList1) {
//            // 处理每一个元素
//            stringMyConsumer.accept(s);
//        }

        //进阶方式二：

//        List<String> stringList2 = Arrays.asList("a", "b", "c", "d");
//        // 利用 Lambda 表达式
//        stringList2.forEach(str -> {
//            System.out.println("我可以对 str（" + str + "） 做任何事情");
//        });

        //进阶方式三：
        List<String> stringList = Arrays.asList("a", "b", "c", "d");
//        stringList.forEach( s -> {
//            // 内部类参数，实现处理逻辑
//            System.out.println("我可以对 s（" + s + "） 做任何事情，而且我还知道他是什么类型");
//        });
        handle(stringList, s -> {
            // 内部类参数，实现处理逻辑
            System.out.println("我可以对 s（" + s + "） 做任何事情，而且我还知道他是什么类型");
        });
    }

    public static <T> void handle(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            // 调用处理方法
            consumer.accept(t);
        }
    }
}
