package com.weixin.backend.util;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Date;
import java.util.Calendar;

public class CalDate {
    public static int getMondayDif() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    public static Date getMonday(Date date) {
        int mondayDif = getMondayDif();
        Date newDay = (Date) DateUtils.addDays(date, mondayDif);
        return newDay;
    }

    public static Date getNextMonday(Date date) {
        int mondayDif = getMondayDif();
        Date newDay = (Date) DateUtils.addDays(date, mondayDif + 7);
        return newDay;
    }
}
