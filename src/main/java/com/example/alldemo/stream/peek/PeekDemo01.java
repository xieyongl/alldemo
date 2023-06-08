//package com.example.alldemo.stream.peek;
//
//import com.example.alldemo.stream.UserEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * TODO peek可以改变原对象的值，而map主要将原对象的值进行映射重新生成新的集合 (但是不推荐，一般用户自测)
// */
//public class PeekDemo01 {
//
//    public static void main(String[] args) {
//
//        //peek
//        ArrayList<UserEntity> userEntities = new ArrayList<>();
//        userEntities.add(new UserEntity("张三", 18));
//        userEntities.add(new UserEntity("李四", 26));
//        userEntities.add(new UserEntity("王二", 10));
//        userEntities.add(new UserEntity("麻子", 28));
//
//        //使用peek修改List集合中user的年龄
//        List<UserEntity> arrs = userEntities.stream().peek(user -> user.setAge(user.getAge() + 5)).collect(Collectors.toList());
////        List<UserEntity> arrs = userEntities.stream().peek(user -> user.setAge(11)).collect(Collectors.toList()); //这样是ok的
//        //遍历输出  //发现年龄都加了5
//        arrs.forEach(user -> System.out.println(user.toString()));
//
//        System.out.println("--------------------------------上面是peek,下面是map--------------------");
//
//        //map
//        ArrayList<UserEntity> userEntities1 = new ArrayList<>();
//        userEntities1.add(new UserEntity("张三", 18));
//        userEntities1.add(new UserEntity("李四", 26));
//        userEntities1.add(new UserEntity("王二", 10));
//        userEntities1.add(new UserEntity("麻子", 28));
//
//        //使用map修改List集合中user的年龄 这样是不行的 map不能更改值
//        List<Object> arrs1 = userEntities1.stream().map(user -> user.setAge(user.getAge() + 5)).collect(Collectors.toList());
////        List<Object> arrs1 = userEntities1.stream().map(user -> user.setAge(11)).collect(Collectors.toList());
//        //遍历输出  //发现年龄都加了5
//        arrs1.forEach(user -> System.out.println(user.toString()));
//    }
//
//}