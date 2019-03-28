package ru.sberbook.sberbookroot;

/**
 * Created by Violetta on 2019-03-20
 */
public class Profile {
    private String login;
    private String passwordHash;
    private String confirmationCode;
    private String resetToken;

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public Profile(String login, String password) {
        this.login = login;
        this.passwordHash = String.valueOf(password.hashCode());
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.passwordHash = String.valueOf(password.hashCode());
    }

}
