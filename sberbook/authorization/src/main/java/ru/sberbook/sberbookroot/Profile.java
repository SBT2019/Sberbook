package ru.sberbook.sberbookroot;

public class Profile {
    private String login;
    private String passwordHash;
    private String resetToken;

    public boolean validatePassword(String pass) {
        return String.valueOf(pass.hashCode()).equals(passwordHash);
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) { this.passwordHash = String.valueOf(password.hashCode()); }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
