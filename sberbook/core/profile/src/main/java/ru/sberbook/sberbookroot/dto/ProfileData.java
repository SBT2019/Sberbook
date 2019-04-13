package ru.sberbook.sberbookroot.dto;

import lombok.Getter;
import lombok.Setter;

//Data for ui
@Getter
@Setter
public class ProfileData {
    private String login;
    private String email;
    private String phone;
    private String img;
}
