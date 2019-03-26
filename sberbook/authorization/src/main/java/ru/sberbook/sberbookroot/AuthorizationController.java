package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AuthorizationController {
    private final ProfileClient profileClient;
    private final EmailService emailService;

    public AuthorizationController(ProfileClient profileClient, EmailService emailService) {
        this.profileClient = profileClient;
        this.emailService = emailService;
    }

    @PostMapping("/login")
    public boolean login(String credential, String pass) {
        Profile profile = profileClient.findProfile(credential);
        if (profile == null) return false;

        return profile.validatePassword(pass);
    }

    @PostMapping("/forgot")
    public boolean recover(String credential) {
        Profile profile = profileClient.findProfile(credential);

        String resetToken = UUID.randomUUID().toString();
        profile.setResetToken(resetToken);
        profileClient.updateUser(profile);

        if (isEmail(credential)) return emailService.sendMail(credential, resetToken);
        if (isPhone(credential)) return false; //TODO sending msg

        return false;
    }

    @PostMapping("/reset")
    public boolean changePass(String credential, String newPass, String resetCode) {
        Profile profile = profileClient.findUserByResetToken(resetCode);
        if (profile == null) return false;

        profile.setPassword(newPass);
        profile.setResetToken(null);
        profileClient.updateUser(profile);

        return true;
    }

    private boolean isPhone(String credential) {
        return true;
    }

    private boolean isEmail(String credential) {
        return credential.contains("@");
    }

}
