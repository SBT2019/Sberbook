package ru.sberbook.sberbookroot;

public class Profile {
    private String login;
    private String passwordHash;

    public boolean validatePassword(String pass) {
        return String.valueOf(pass.hashCode()).equals(passwordHash);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
