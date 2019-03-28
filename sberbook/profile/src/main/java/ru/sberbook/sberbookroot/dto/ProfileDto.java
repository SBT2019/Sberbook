package ru.sberbook.sberbookroot.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProfileDto {
    private String credential;
    private String passwordHash;
    private String confirmationCode;
    private String resetToken;
}
