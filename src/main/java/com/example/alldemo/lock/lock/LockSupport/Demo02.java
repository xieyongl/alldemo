package com.example.alldemo.lock.lock.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/11/24 18:46
 **/
public class Demo02 {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);//让子线程睡眠1s 保证主线程有机会给许可证
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("child thread begin park");
            LockSupport.park();
            System.out.println("child thread unpark");
        });

        thread.start();
        LockSupport.unpark(thread); //这里主线程给了许可证之后 子线程才能成功执行完成 并打印出 child thread unpark

    }
}


