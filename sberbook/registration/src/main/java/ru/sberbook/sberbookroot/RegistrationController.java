package ru.sberbook.sberbookroot;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@RestController
public class RegistrationController {
    private final ProfileClient profileClient;
    private final EmailService emailService;

    @GetMapping("/registration")
    public boolean registerUserAccount(String credential, String pass) {
        if (profileClient.checkProfile(credential)) return false;

        Profile profile = new Profile(credential,pass);
        String confirmationCode = UUID.randomUUID().toString();
        profile.setConfirmationCode(confirmationCode);
        profile.setPassword(pass);
        profile.setLogin(credential);
        profileClient.createUser(profile);

        if (isEmail(credential)) return emailService.sendMail(credential, confirmationCode);
        if (isPhone(credential)) return true; //TODO sending msg

        return false;
    }

    @GetMapping("/confirmation")
    public boolean confirmation(String confirmationCode){
        Profile profile = profileClient.findUserByConfirmationCode(confirmationCode);
        if (profile == null) return false;

        profile.setConfirmationCode(null);
        profileClient.addUser(profile);
        return true;
    }

    private boolean isPhone(String credential) {
        String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";

        Pattern pattern = Pattern.compile(regex);
        if (credential == null) return false;
        return pattern.matcher(credential).matches();
    }

    private boolean isEmail(String credential) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);
        if (credential == null) return false;
        return pattern.matcher(credential).matches();
    }
}
