package com.example.alldemo.utils.dateUtil.localdate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class LocalDateDemo01 {

    public static void main(String[] args) {


        final LocalDate localDate1 = LocalDate.of(2023, 03, 9);
        System.out.println(localDate1);
        System.out.println("指定时间加上x天后为：" + localDate1.plusDays(30));
        System.out.println("指定时间减去x天后为：" + localDate1.minusMonths(2));
        System.out.println("本月的第几天：" + localDate1.getDayOfMonth());
        System.out.println("本周的第几天：" + localDate1.getDayOfWeek());
        System.out.println("本周的第几天(getDisplayName方法表示用不同文本展示)：" + localDate1.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
        System.out.println("本年的第几天：" + localDate1.getDayOfYear());
        System.out.println("此年总天数为：" + localDate1.lengthOfYear());
        System.out.println("替换年后的时间为：" + localDate1.withYear(2023));
        System.out.println("是否是闰年：" + localDate1.isLeapYear());

        System.out.println("---------------------------");

        LocalDate localDate2 = localDate1.parse("2022-04-21");
        System.out.println("字符串转LocalDate:" + localDate2);


        //（2）使用特定格式化形式从文本字符串获取LocalDate实例
        String str = "2019-03-03";
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(str, fmt1);
        System.out.println("使用特定格式化形式从文本字符串获取LocalDate实例：" + date);


        //（3）使用特定格式化形式将LocalDate转为字符串
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dateStr = today.format(fmt);
        System.out.println("使用特定格式化形式将LocalDate转为字符串：" + dateStr);


        //（1）LocalDate转化为Date
        ZonedDateTime zonedDateTime = LocalDate.now().atStartOfDay(ZoneId.systemDefault());
        Date date1 = Date.from(zonedDateTime.toInstant());
        System.out.println("LocalDate转化为Date：" + new SimpleDateFormat("yyyy-MM-dd").format(date1));


        //（2）Date转化为LocalDate
        LocalDate localDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Date转化为LocalDate：" + localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));

    }
}