package com.example.alldemo.lock.lock.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @description: TODO LockSupport比Object的wait/notify有两大优势：
 *                    LockSupport不需要在同步代码块里 。所以线程间也不需要维护一个共享的同步对象了，实现了线程间的解耦。
 *                    unpark函数可以先于park调用，所以不需要担心线程间的执行的先后顺序。
 *
 *                    unpark: 相当于颁发许可证
 *                    park: 校验是否有许可证，有就放行，没有就阻塞
 * @author: xieyong
 * @date: 2022/11/11 14:26
 **/
public class Demo01 {


//    public static void main(String[] args) throws Exception {
//        final Object obj = new Object();
//        Thread A = new Thread(() -> {
//            int sum = 0;
//            for (int i = 0; i < 10; i++) {
//                sum += i;
//            }
//            try {
//                synchronized (obj) {
//                    obj.wait();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println(sum);
//        });
//        A.start();
//        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
//        Thread.sleep(1000);
//        synchronized (obj) {
//            obj.notify();
//        }
//    }

    public static void main(String[] args) throws Exception {
        Thread A = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            LockSupport.park();
            System.out.println(sum);
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        Thread.sleep(1000);
        LockSupport.unpark(A);
    }

}