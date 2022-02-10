package com.example.alldemo.lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/10 14:14
 **/
public class CasDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(0, 1);

        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    //expectedValue 预期值
                    int expectedValue = cas.get();
                    //传入预期值 和 随机的新值，因为初始内存值为0，如果这里第一次预期值为cas.get()，能保证至少成功一次
                    boolean b = cas.compareAndSet(expectedValue, (int)(Math.random() * 101));
                    System.out.println(Thread.currentThread().getName() + " " + b);
                }
            }).start();
        }
    }
}


class CompareAndSwap{

    private int value; //旧值默认为0

    //获取内存值
    public synchronized int get(){
        return value;
    }

    //比较并替换
    public synchronized int compareAndSwap(int expectedValue, int newValue){
        //旧值
        int oldValue = value;
        //如果旧值==预期值，则替换成新值
        if(oldValue == expectedValue){
            System.out.println("内存值：" + value + "  预期值：" + expectedValue + "  新值：" + newValue);
            this.value = newValue;
        }

        return oldValue;
    }

    //设置
    public synchronized boolean compareAndSet(int expectedValue, int newValue){
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}
