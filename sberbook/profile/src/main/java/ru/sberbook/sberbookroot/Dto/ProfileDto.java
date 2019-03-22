package ru.sberbook.sberbookroot.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProfileDto {
    private String login;
    private String passwordHash;
    private String confirmationCode;
    private String resetToken;
}
