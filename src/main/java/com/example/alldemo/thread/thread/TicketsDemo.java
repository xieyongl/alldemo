package com.example.alldemo.thread.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: TODO 多线程卖票问题
 * @author: xieyong
 * @date: 2022/2/8 17:01
 **/
public class TicketsDemo {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        System.out.println("开始卖票！");
        long startTime = System.currentTimeMillis();

        Tickets tickets = new Tickets(1000);
        for (int i = 0; i < 10; i++) {
            executorService.execute(tickets);
        }
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        long hostTime = endTime - startTime;
        System.out.println("卖票耗时：" + hostTime);

    }
}

class Tickets implements Runnable {

    int total;

    Tickets(int total) {
        this.total = total;
    }

//    @Override
//    public void run() {
//        while (true) {
//            synchronized (this) {
//                try {
//                    if (total == 0) {
//                        return;
//                    }
//                    Thread.sleep(0);
//                    System.out.println("当前线程：" + Thread.currentThread().getName() + "   买到一张票，当前剩余票数：" + --total);
//                    if (total < 0) {
//                        System.out.println("票已售罄！");
//                        return;
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (total == 0) {
                    return;
                }
                Thread.sleep(10);
                System.out.println("当前线程：" + Thread.currentThread().getName() + "   买到一张票，当前剩余票数：" + --total);
                if (total <= 0) {
                    System.out.println("票已售罄！");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

