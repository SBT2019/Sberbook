package ru.sberbook.sberbookroot;

public class Profile {
    private String login;
    private String passwordHash;
    private String resetToken;
    private String confirmationCode;

    public Profile(String login, String passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
