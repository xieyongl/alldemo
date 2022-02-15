package com.example.alldemo.lock.lock.conditon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/14 11:47
 **/
public class ConditonDemo {
    public static void main(String[] args) {
        a a = new a();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.decrease();
            }
        }, "B").start();
    }
}

class a {
    public int nummber = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (nummber != 0) {
                condition.await();
            }
            nummber++;
            System.out.println(Thread.currentThread().getName() + ">>" + nummber);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrease() {
        lock.lock();
        try {
            while (nummber != 1) {
                condition.await();
            }
            nummber--;
            System.out.println(Thread.currentThread().getName() + ">>" + nummber);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


