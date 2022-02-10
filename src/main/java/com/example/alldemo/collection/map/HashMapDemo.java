package com.example.alldemo.collection.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/8 15:56
 **/
public class HashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1", "111");
        concurrentHashMap.put("2", "222");

        HashMap<String, Object> hashMap = new HashMap<>(6);
        hashMap.put("a", "aaa");
        hashMap.put("b", "bbb");
        System.out.println(hashMap.get("a"));

    }
}