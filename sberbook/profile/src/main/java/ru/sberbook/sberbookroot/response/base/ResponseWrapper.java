package ru.sberbook.sberbookroot.response.base;

import ru.sberbook.sberbookroot.util.ConcurrentSimpleDateFormat;

import java.util.Date;

public class ResponseWrapper {

    private final Response response;
    private final Object data;
    private final String date;

    public ResponseWrapper(Response response, Object data) {
        this.response = response;
        this.data = data;
        this.date = ConcurrentSimpleDateFormat.format(new Date());
    }
}
