package com.example.alldemo.stream.parallel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Stream;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/11/10 10:45
 **/
public class Demo01 {

    public static void main(String[] args) {

        List<String> s = Arrays.asList("1", "2", "3", "4", "5", "6");
        s.stream().parallel();
        Stream.of(s).parallel();

        HashMap<String, Object> map = new HashMap<String, Object>() {
            {
                put("1","1");
                put("2","2");
                put("3","3");
            }
        };

        LockSupport.park();

        System.out.println(map);

    }
}