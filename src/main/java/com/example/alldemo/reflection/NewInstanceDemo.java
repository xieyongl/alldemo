package com.example.alldemo.reflection;

import java.util.Random;

/**
 * 通过发射创建对应的运行时类的对象
 */
class NewInstanceTest {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "com.example.alldemo.reflection.obj.Tiger";
                    break;
                case 1:
                    classPath = "com.example.alldemo.reflection.obj.Lion";
                    break;
                case 2:
                    classPath = "com.example.alldemo.reflection.obj.Elephant";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建一个指定类的对象。
     * classPath:指定类的全类名
     *
     * @param classPath
     * @return
     * @throws Exception
     */
    static Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}