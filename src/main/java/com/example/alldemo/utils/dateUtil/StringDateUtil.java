package com.example.alldemo.utils.dateUtil;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.alldemo.utils.hutool.Date;

public class StringDateUtil {

    /**
     * 截取String类型时间 年月日
     * @return
     */
    private static String getYmd(String strTime) {

        String format = DateUtil.format(DateUtil.parse(strTime), DatePattern.NORM_DATE_PATTERN);
        return format;
    }

    /**
     * String - String
     * 传参yyyy-MM-dd 转换为当天开始和结束 yyyy-MM-dd HH:mm:ss
     * @return
     */
    private static String getEndpointTime(String strTime) {
        String startTime = DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(strTime)), DatePattern.NORM_DATETIME_PATTERN);
        String endTime = DateUtil.format(DateUtil.endOfDay(DateUtil.parse(strTime)), DatePattern.NORM_DATETIME_PATTERN);
        return startTime + "----" + endTime;
    }


    public static void main(String[] args) {

        String s = "2023-02-27 00:00:00";
        System.out.println(getYmd(s));

        String strTime = "2023-02-27";
        System.out.println(getEndpointTime(strTime));

        DateTime now = DateTime.now();
        System.out.println(now);
        if (DateTime.now().after(DateUtil.endOfDay(Convert.toDate("2023-03-28")))) {
            System.out.println("可提交");
        } else {
            System.out.println("不可提交");
        }
    }

}