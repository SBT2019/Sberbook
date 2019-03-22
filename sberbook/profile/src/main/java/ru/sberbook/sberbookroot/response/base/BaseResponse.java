package ru.sberbook.sberbookroot.response.base;

public class BaseResponse implements Response {
    private final int code;
    private final String status;

    public BaseResponse(int code, String status) {
        this.code = code;
        this.status = status;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
