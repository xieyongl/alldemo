package com.example.alldemo.lock.synchronize;


import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/15 14:08
 **/
public class PrintDemo {

    public static void main(String[] args) throws InterruptedException {
        L l = new L();  //new 一个对象
        System.out.println(ClassLayout.parseInstance(l).toPrintable());//输出 l对象 的布局
    }

}

//对象类
class L {
    private boolean myboolean = true;
}

