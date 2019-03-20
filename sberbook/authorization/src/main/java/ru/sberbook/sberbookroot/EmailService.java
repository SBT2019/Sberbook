package ru.sberbook.sberbookroot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Random;

/**
 * Created by Violetta on 2019-03-20
 */
public class EmailService {

    @Autowired
    private static JavaMailSender mailSender;

    public static boolean sendMail(String to, String resetToken) {

        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mail, true);
            messageHelper.setTo(to);
            messageHelper.setSubject("Sberbook pass changing");
            messageHelper.setText("Code to reset your password: "+resetToken);
            mailSender.send(mail);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
