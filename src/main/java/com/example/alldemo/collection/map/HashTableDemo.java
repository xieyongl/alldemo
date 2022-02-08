package com.example.alldemo.collection.map;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/8 15:57
 **/
public class HashTableDemo {

    public static void main(String[] args) {


        //线程安全，使用了synchronized
        Hashtable<String, Object> hashtable = new Hashtable();
        hashtable.put("1", "1");
        hashtable.put("2", "2");
        System.out.println(hashtable);
    }

}