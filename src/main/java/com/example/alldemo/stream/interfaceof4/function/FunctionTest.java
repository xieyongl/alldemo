package com.example.alldemo.stream.interfaceof4.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {

        //方式一：
        MyFunction<String, String> myFunction = new MyFunction<>();
        myFunction.apply("J3-白起...");

        //方式二：
        List<String> nameList = Arrays.asList("J3-baiqi", "shaheshagn", "sunwukong");
        List<Integer> nameLengthList = functionHandle(nameList, String::length);
        System.out.println(nameLengthList);
    }

    /**
     * 获取列表中，姓名的长度
     *
     * @param nameList 名字列表
     * @param function 名字长度列表
     * @return
     */
    public static List<Integer> functionHandle(List<String> nameList, Function<String, Integer> function) {
        List<Integer> nameLengthList = new ArrayList<>(nameList.size());
        nameList.forEach(name -> nameLengthList.add(function.apply(name)));
        return nameLengthList;
    }
}