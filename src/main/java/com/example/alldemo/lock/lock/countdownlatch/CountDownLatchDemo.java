package com.example.alldemo.lock.lock.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @description: TODO 计数器
 * @author: xieyong
 * @date: 2022/2/14 16:54
 **/
public class CountDownLatchDemo {
    /**
     * 计数器
     * 原理:
     * countDownLatch.countDown(); //数量减1
     * countDownLatch.await();// 等待计数器归零,然后再向下执行
     * 每次有线程调用countDown()数量-1,假设计数器变为0,countDownLatch.await();就会被唤醒,继续执行
     */

    public static void main(String[] args) throws InterruptedException {
        //相当于计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        //计数器总数是5,当减少为0,任务才继续向下执行
        for (int i = 1; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "==>start");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await(); // 等待计数器归零,然后再向下执行
        System.out.println("main线程继续向下执行");
    }

}