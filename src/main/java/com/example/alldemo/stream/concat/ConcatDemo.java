package com.example.alldemo.stream.concat;

import java.util.stream.Stream;

/**
 * //TODO concat: 将两个流合并为一个
 */
public class ConcatDemo {

    public static void main(String[] args) {

        Stream<String> stream1 = Stream.of("a","b","c");
        Stream<String> stream2 = Stream.of("x", "y", "z");
// 通过concat方法将两个流合并为一个新的流
        Stream.concat(stream1,stream2).forEach(System.out::println);
    }
}