package ru.sberbook.sberbookroot;

import lombok.Setter;

/**
 * Created by Violetta on 2019-03-20
 */
@Setter
public class Profile {
    private String login;
    private String passwordHash;
    private String confirmationCode;
    private String resetToken;

    public Profile(String login, String passwordHash) {
        this.login = login;
        setPassword(passwordHash);
    }

    public void setPassword(String password) {
        this.passwordHash = String.valueOf(password.hashCode());
    }
}
