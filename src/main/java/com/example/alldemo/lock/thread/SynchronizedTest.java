package com.example.alldemo.lock.thread;


import lombok.extern.slf4j.Slf4j;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/1/18 16:35
 **/
@Slf4j
public class SynchronizedTest {

    public static void main(String[] args) {

        Number n1 = new Number();
        new Thread(()->{ n1.a(); }).start();
        new Thread(()->{ n1.b(); }).start();
    }
}

class Number{
    public synchronized void a() {
        System.out.println("1");
    }

    public synchronized void b() {
        System.out.println("2");
    }
}

