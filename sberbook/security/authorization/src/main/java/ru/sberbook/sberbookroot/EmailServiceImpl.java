package ru.sberbook.sberbookroot;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by Violetta on 2019-03-20
 */
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    @Override
    public boolean sendMail(String to, String resetToken) {
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
