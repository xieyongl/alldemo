package com.example.alldemo.lock.thread;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/10 14:22
 **/
public class ThreadsPrintDemo {

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " " + j);
                    }
                }
            }).start();
//            new Thread(() -> {
//
//                for(int j=0; j<10; j++) {
//                    System.out.println(Thread.currentThread().getName() + " " + j);
//                }
//
//            }).start();
        }

    }

}