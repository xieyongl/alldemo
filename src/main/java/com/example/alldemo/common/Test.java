package com.example.alldemo.common;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/9 11:35
 **/
public class Test implements Runnable {


    @Override
    public void run() {
        AtomicInteger atomicInteger = new AtomicInteger();
        // 加锁操作
        System.out.println("hello");
        atomicInteger.set(110);
        for (int i=0; i<100; i++) {
            atomicInteger.incrementAndGet();
            System.out.println(atomicInteger.get());
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread thread = new Thread(test);
        thread.start();
    }
}
