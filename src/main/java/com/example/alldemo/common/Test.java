package com.example.alldemo.common;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/9 11:35
 **/
public class Test {


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (int i = 100000; i <= 200000; i++) {
                    boolean is=true;
                    for (int j = 2; j < i; j++) {
                        if (i%j==0){
                            is=false;
                            break;
                        }
                    }
                    if (is)count++;
                }
                System.out.println(Thread.currentThread().getName()+":100000到200000之间有"+count+"个素数");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count2 = 0;
                for (int i = 2; i <= 100000; i++) {
                    boolean is=true;
                    for (int j = 2; j < i; j++) {
                        if (i%j==0){
                            is=false;
                            break;
                        }
                    }
                    if (is)count2++;
                }
                System.out.println(Thread.currentThread().getName()+":2到100000之间有"+count2+"个素数");
            }
        }).start();
    }

}
