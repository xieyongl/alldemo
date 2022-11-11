package com.example.alldemo.stream.parallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/11/10 10:42
 **/
public class Demo01 {

    public static void main(String[] args) {


        Thread thread0 = new Thread();
        List<String> s = Arrays.asList("1", "2", "3", "4", "5", "6");

        System.out.println(s.parallelStream().count());

        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29);
        final long begin = System.currentTimeMillis();
        numbers.parallelStream().map(k -> {
            try {
                Thread.sleep(1000);
                System.out.println((System.currentTimeMillis() - begin) + "ms => " + k + " \t" + Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return k;
        }).collect(Collectors.toList());
    }

}