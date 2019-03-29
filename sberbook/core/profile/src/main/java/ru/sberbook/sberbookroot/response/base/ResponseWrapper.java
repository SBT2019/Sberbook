package ru.sberbook.sberbookroot.response.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public static ResponseEntity<ResponseWrapper> render(Object object, Response response, HttpStatus status) {
        return new ResponseEntity<>(new ResponseWrapper(response, object), status);
    }
}
