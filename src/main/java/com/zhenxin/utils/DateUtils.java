package com.zhenxin.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间转换
 */

public class DateUtils {
    /**
     * 格式转换
     * yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String dateFormat(Date date){
        long time = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(time);
        return format;
    }
    /**
     * 格式转换
     * yyyyMMddHHmmss
     * @return
     */
    public static String dateFormatToString() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        return dateName;
    }

}
