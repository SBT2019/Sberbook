package ru.sberbook.sberbookroot;

import lombok.Setter;

@Setter
public class Profile {
    private String login;
    private String passwordHash;
    private String resetToken;
    private String confirmationCode;

    public boolean validatePassword(String pass) {
        return String.valueOf(pass.hashCode()).equals(passwordHash);
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public void setPassword(String password) { this.passwordHash = String.valueOf(password.hashCode());


    }
}
