package com.example.alldemo.utils.gsonUtil;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/11/16 16:50
 **/
public class Demo01 {

    public static void main(String[] args) {

        //【对象转换】
        User user = User.builder().id(1).age(11).name("xy").sex(1).mobiles(Arrays.asList("111222333444", "555666777888")).build();

        String s = new Gson().toJson(user);
        System.out.println("对象转json字符串：" + s);
        User user1 = User.formJson(s);
        System.out.println("json字符串转对象：" + user1);

        //【集合转换】
        List<User> userList = new ArrayList<>();
        userList.add(User.builder().id(1).age(11).name("xy").sex(1).mobiles(Arrays.asList("111222333444", "555666777888")).build());
        userList.add(User.builder().id(2).age(22).name("xy2").sex(1).mobiles(Arrays.asList("111222333444", "555666777888")).build());

        String ss = new Gson().toJson(userList);
        System.out.println("List集合转json字符串：" + ss);

//        List list = new Gson().fromJson(ss, List.class); //这种方式会导致转换的数据和元数据有差异 所以用下面的 map集合也一样
        List list = new Gson().fromJson(ss, new TypeToken<List<User>>(){}.getType());

        System.out.println("json字符串转List集合：" + list);

    }
}