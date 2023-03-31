package com.example.alldemo.stream.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//TODO 讲单个字符串里面的单词 独立为一个字符串

public class FlatmapDemo {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("java,spring,hibernate", "python,django", "ruby,rails");

        List<String> wordList = stringList.stream()
                .flatMap(str -> Arrays.stream(str.split(",")))
                .collect(Collectors.toList());

        System.out.println(wordList);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        List<String> letters = fruits.stream()
                .flatMap(str -> Arrays.stream(str.split("")))
                .collect(Collectors.toList());
        System.out.println(letters);
    }
}