package ru.sberbook.sberbookroot;

public class Profile {
    private final String login;
    private final String passwordHash;

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
