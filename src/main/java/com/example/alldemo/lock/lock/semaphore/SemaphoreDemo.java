package com.example.alldemo.lock.lock.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/14 17:07
 **/
public class SemaphoreDemo {

    /**
     * //TODO 原理:
     * semaphore.acquire(); //获取信号量,假设如果已经满了,等待信号量可用时被唤醒
     * semaphore.release(); //释放信号量
     * 作用: 多个共享资源互斥的使用!并发限流,控制最大的线程数
     * @param args
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            int temp = i;
            new Thread(() -> {
                try {
                    semaphore.acquire(); //获取
                    System.out.println(temp + "号车抢到车位");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); //释放
                    System.out.println(temp + "号车离开车位");
                }
            }).start();
        }
    }
}
