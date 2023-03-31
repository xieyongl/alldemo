package com.example.alldemo.lock.lock.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: TODO CyclicBarrier类可以实现一组线程相互等待，当所有线程都到达某个屏障点后再进行后续的操作。 类似于加法计数器
 * @author: xieyong
 * @date: 2022/2/14 17:04
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        /**
         * 集齐7个龙珠召唤神龙
         */
        // 召唤龙珠的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功! ");
        });
        for (int i = 1; i <= 7; i++) {
            int temp = i;
            //lambda 能拿到i吗
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集" + temp + "号龙珠");

                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "收集" + temp + "号龙珠");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
