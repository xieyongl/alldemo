package com.example.alldemo.collection.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @description: TODO 同步队列
 * @author: xieyong
 * @date: 2022/2/8 16:10
 **/
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        /**
         * SynchronousQueue同步队列
         * 同步队列 没有容量，也可以视为容量为1的队列；
         * 进去一个元素，必须等待取出来之后，才能再往里面放入一个元素；
         *
         * put方法 和 take方法:
         * Synchronized 和 其他的BlockingQueue 不一样 它不存储元素；
         * put了一个元素，就必须从里面先take出来，否则不能再put进去值！
         * 并且SynchronousQueue 的take是使用了lock锁保证线程安全的。
         */

        //同步队列
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();
        //研究一下 如果判断这是一个同步队列

        //使用两个进程
        // 一个进程 放进去
        // 一个进程 拿出来
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" Put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName()+" Put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName()+" Put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" Take "+synchronousQueue.take());
//                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" Take "+synchronousQueue.take());
//                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" Take "+synchronousQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}