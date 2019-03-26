package ru.sberbook.sberbookroot.response.base;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseResponse implements Response {
    private final int code;
    private final String status;
}
