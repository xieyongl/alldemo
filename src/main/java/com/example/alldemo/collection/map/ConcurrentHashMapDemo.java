package com.example.alldemo.collection.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/8 15:59
 **/
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        //线程安全
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1", "111");
        concurrentHashMap.put("2", "222");
        System.out.println(concurrentHashMap.get("1"));
        System.out.println(concurrentHashMap);
    }

}