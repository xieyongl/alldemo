package com.example.alldemo.testdemo;


import com.example.alldemo.proxy.staticProxy.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {

        List<P> list = Arrays.asList(new P(1, "11"), new P(2, "22"));
        System.out.println(list);
        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(s -> s.getId(), s -> s.getName()));
        System.out.println(collect);
        if (collect.get(3) != null) {
            System.out.println("this is true!");
        }


    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class P {

    private Integer id;
    private String name;
    private boolean a;

    public P (Integer id, String name) {
        this.id = id;
        this.name = name;

    }
}