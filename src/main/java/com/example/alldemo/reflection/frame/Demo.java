package com.example.alldemo.reflection.frame;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = Demo.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("properties/reflection/test.properties");
        pro.load(is);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);

        final Class<Person> personClass = Person.class;
        final Person person = personClass.newInstance();
        final Method method1 = personClass.getMethod(methodName);
        method1.invoke(person);


    }


}


