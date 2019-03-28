package ru.sberbook.sberbookroot;

public interface EmailService {
    boolean sendMail(String to, String resetToken);
}
