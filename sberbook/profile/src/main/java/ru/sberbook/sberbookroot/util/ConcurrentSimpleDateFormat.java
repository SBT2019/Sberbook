package ru.sberbook.sberbookroot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentSimpleDateFormat {
    public static final ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        }
    };

    private ConcurrentSimpleDateFormat () {}

    public static String format(Date date) { return sdf.get().format(date);}
}
