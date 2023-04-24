package com.example.alldemo.stream.parallelStream;

import java.util.stream.Stream;

public class Demo02 {

    public static void main(String[] args) {

        Stream.of(1, 4, 2, 6, 1, 5, 9)
                .parallel() // 将流转换为并发流，Stream处理的时候就会通过多线程处理
                .filter(s -> {
                    System.out.println(Thread.currentThread() + " s=" + s);
                    return s > 2;
                }).count();

    }
}