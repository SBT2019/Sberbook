package ru.sberbook.sberbookroot.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.sberbook.sberbookroot.response.base.Response;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public enum UserResponse implements Response, Serializable {
    USER_CREATION_SUCCESS(100, "Новый пользователь создан"),
    USER_CREATION_FAILURE(101, "Ошибка создания пользователя"),
    USER_FOUND(102, "Пользователь найден"),
    USER_NOT_FOUND(103, "Пользователь не найден"),
    USER_FINDING_ERROR(103, "Ошибка при попытке найти пользователя");

    private final int code;
    private final String status;

    @Override
    public String toString() {
        return "Код " + code + ": " + status;
    }
}
