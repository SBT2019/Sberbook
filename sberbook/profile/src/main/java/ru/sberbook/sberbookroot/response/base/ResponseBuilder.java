package ru.sberbook.sberbookroot.response.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
    public static ResponseEntity<ResponseWrapper> render(Object object, Response response, HttpStatus status) {
        return new ResponseEntity<>(new ResponseWrapper(response, object), status);
    }
}
