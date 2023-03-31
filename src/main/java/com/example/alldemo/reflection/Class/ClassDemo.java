package com.example.alldemo.reflection.Class;

import cn.hutool.core.date.DateUtil;

import java.lang.annotation.ElementType;

/**
 * //TODO 关于java.lang.Class类的理解
 * 1.类的加载过程：
 * 程序经过Javac.exe命令后，会生成一个或多个字节码文件(.class结尾)。
 * 接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
 * 加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
 * 运行时类，就作为Class的一个实例。
 *
 * 2.换句话说，Class的实例就对应着一个运行时类。
 */
public class ClassDemo {

    public static void main(String[] args) {

        String s = "2023-03-22";
        System.out.println(DateUtil.parse(s));

        Class s1 = Object.class;
        Class s2 = Comparable.class;
        Class s3 = String[].class;
        Class s4 = int[][].class;
        Class s5 = ElementType.class;
        Class s6 = Override.class;
        Class s7 = int.class;
        Class s8 = void.class;
        Class s9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class s10 = a.getClass();
        Class s11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(s10 == s11);

        System.out.println("s1：" + s1);
        System.out.println("s2：" + s2);
        System.out.println("s3：" + s3);
        System.out.println("s4：" + s4);
        System.out.println("s5：" + s5);
        System.out.println("s6：" + s6);
        System.out.println("s7：" + s7);
        System.out.println("s8：" + s8);
        System.out.println("s9：" + s9);
        System.out.println("s10：" + s10);
        System.out.println("s11：" + s11);


    }

}