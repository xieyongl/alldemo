package com.example.alldemo.utils.dateUtil.localdatetime;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * //TODO 熟悉了LocalDate、LocalTime，api都差不多
 */
public class LocalDateTimeDemo01 {

    public static void main(String[] args) {

        System.out.println("当前时间：" + LocalDateTime.now());

        LocalDateTime localDateTime = LocalDateTime.of(2023, 03, 9, 14, 15, 33);
        System.out.println("指定时间：" + localDateTime);

        System.out.println("星期几（英文） : " + LocalDateTime.now().getDayOfWeek());
        System.out.println("星期几（数字） : " + LocalDateTime.now().getDayOfWeek().getValue());
        System.out.println("本年的第几天 : " + LocalDateTime.now().getDayOfYear());
        System.out.println("指定时间和当前时间是否相等：" + localDateTime.isEqual(LocalDateTime.now()));


        System.out.println("-----------------------------------------------------");
        System.out.println("LocalDateTime与 String 之间的转换: ");


        System.out.println("当前时间的日期部分：" + LocalDateTime.now().toLocalDate());
        System.out.println("当前时间的时间部分：" + LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        //从文本字符串获取LocalDateTime实例
        LocalDateTime ldt2 = LocalDateTime.parse("2012-12-07T21:20:06.303995200");
        System.out.println(ldt2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        //使用特定格式化形式从文本字符串获取LocalDateTime实例
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt3 = LocalDateTime.parse("2023-12-07 21:20:06", df1);
        System.out.println(ldt3);

        //使用特定格式化形式将LocalDateTime转为字符串
        String ldt4 = df1.format(ldt3);
        System.out.println(ldt4);

        System.out.println("-----------------------------------------------------");
        System.out.println("LocalDateTime与 Date 之间的转换: ");

        //LocalDateTime转化为Date
        ZonedDateTime zdt = LocalDateTime.now().atZone(ZoneId.systemDefault());
        Date date1 = Date.from(zdt.toInstant());
        System.out.println("LocalDateTime转化为Date：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1));

        //Date转化为LocalDateTime
        LocalDateTime ldt5 = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("Date转化为LocalDateTime：" + ldt5.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}