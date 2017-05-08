package com.bill.mvc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenking on 2017/5/8.
 */
public class DateUtil {
    // get now time and change to String, yyyy-MM-dd HH:mm:ss
    public static String DateToStrNowTime(){
        Date now=new Date();
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dataFormat.format(now);

    }
    public static String GetNowTimeNoEmpty(){
        Date now=new Date();
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        return dataFormat.format(now);
    }
}
