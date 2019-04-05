package ru.sberbook.sberbookroot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentSimpleDateFormat {
    private static final ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));

    public static String format(Date date) { return sdf.get().format(date);}
}
