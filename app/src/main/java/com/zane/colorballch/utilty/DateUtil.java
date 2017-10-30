package com.zane.colorballch.utilty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shizhang on 2017/10/30.
 */

public class DateUtil {

    public static String nowDateStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return simpleDateFormat.format(new Date());
    }

    public static int x(String timeStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        int hours = 0;
        try {
            long from = simpleDateFormat.parse(timeStr).getTime();
            long now = new Date().getTime();
            hours = (int) ((now - from)/(1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return hours;
    }
}
