package com.example.alldemo.utils.dateUtil.localtime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeDemo01 {

    public static void main(String[] args) {


        System.out.println("当前时间的时分秒：" + LocalTime.now());


        LocalTime time = LocalTime.of(14, 34, 34);

        System.out.println("指定时分秒：" + time);
        System.out.println("获取指定时分秒的小时：" + time.getHour());
        System.out.println("增加x小时：" + time.plusHours(6));
        System.out.println("减少x分钟：" + time.minusMinutes(3));
        System.out.println("指定时间是否在当前时间之后：" + time.isAfter(LocalTime.now()));
        System.out.println("与当前时间比较：" + (time.compareTo(LocalTime.now()) > 0 ? "大于当前时间" : "小于等于当前时间"));

        System.out.println("-------------------------------------");

        //（1）从文本字符串获取LocalTime实例
        LocalTime localTime1 = LocalTime.parse("12:30:30");
        System.out.println(localTime1);

        //（2）使用特定格式化形式从文本字符串获取LocalTime实例
        LocalTime localTime2 = LocalTime.parse("12:30:30", DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(localTime2);

        //（3）使用特定格式化形式将LocalTime转为字符串
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime3 = LocalTime.now();
        System.out.println(localTime3.format(df1));
    }
}