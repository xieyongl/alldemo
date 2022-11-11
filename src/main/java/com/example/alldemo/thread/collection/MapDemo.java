package com.example.alldemo.thread.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: TODO Fail-fast（失败安全）机制与 Fail-safe（安全失败）机制
 * @author: xieyong
 * @date: 2022/6/16 10:32
 **/
public class MapDemo {

    public static void main(String[] args) {

//        //TODO 快速失败
//        Map<String, Object> map = new HashMap<>();
//        map.put("1", 1);
//        map.put("2", 2);
//        map.put("3", 3);
//        Iterator iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(map.get(iterator.next()));
//            //迭代器遍历的时候会报错
//            map.put("4", 4);
//        }

        //TODO 失败安全
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3, 4, 5, 6});
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            Integer i = (Integer) iterator.next();
            System.out.println(i);
            if (i==3) {
                //之类迭代器遍历的时候不会报错，因为这里遍历的是copyOnWriteArrayList的拷贝，新增元素是在copyOnWriteArrayList原集合
                copyOnWriteArrayList.add(7);
            }
        }
        System.out.println(copyOnWriteArrayList);
    }
}