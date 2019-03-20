package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static ru.sberbook.sberbookroot.EmailService.sendMail;

@RestController
public class RegistrationController {

    private final ProfileClient profileClient;

    public RegistrationController(ProfileClient profileClient) {
        this.profileClient = profileClient;
    }

    @GetMapping("/registration")
    public boolean registerUserAccount(String credential, String pass) {
        if (profileClient.checkProfile(credential)) return false;

        Profile profile = new Profile(credential,pass);
        String confirmationCode = UUID.randomUUID().toString();
        profile.setConfirmationCode(confirmationCode);
        profile.setPassword(pass);
        profile.setLogin(credential);
        profileClient.createUser(profile);

        if (isEmail(credential)) return sendMail(credential, confirmationCode);
        if (isPhone(credential)) return true; //TODO sending msg

        return false;
    }

    @GetMapping("/confirmation")
    public boolean confirmation(String credentials, String confirmationCode){
        Profile profile = profileClient.findUserByConfirmationCode(confirmationCode);
        if (profile == null) return false;

        profileClient.addUser(profile);
        return true;
    }

    private boolean isPhone(String credential) {
        return true;
    }

    private boolean isEmail(String credential) {
        return credential.contains("@");
    }



}
