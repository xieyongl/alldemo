package com.example.alldemo.stream.match;

import java.util.Arrays;
import java.util.List;

/**
 * anyMatch：判断的条件里，任意一个元素成功，返回true
 *
 * allMatch：判断条件里的元素，所有的都是，返回true
 *
 * noneMatch：与allMatch相反，判断条件里的元素，所有的都不是，返回true
 *
 * count方法，跟List接口中的 .size() 一样，返回的都是这个集合流的元素的长度，不同的是，流是集合的一个高级工厂，中间操作是工厂里的每一道工序，我们对这个流操作完成后，可以进行元素的数量的和；

 */
public class AnyMatchDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 1, 1, 1);

        boolean anyMatch = list.stream().anyMatch(f -> f == (1));
        boolean allMatch = list.stream().allMatch(f -> f == (1));
        boolean noneMatch = list.stream().noneMatch(f -> f == (1));
        long count = list.stream().filter(f -> f == (1)).count();

        System.out.println(anyMatch);  // true
        System.out.println(allMatch);  // false
        System.out.println(noneMatch); // false
        System.out.println(count);     // 4
    }

}