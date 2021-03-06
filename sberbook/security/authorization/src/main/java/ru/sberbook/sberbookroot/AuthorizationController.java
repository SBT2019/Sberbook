package ru.sberbook.sberbookroot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@RestController
public class AuthorizationController {
    @Autowired
    private final UserRepository userRepository;

    private final ProfileClient profileClient;
    private final EmailService emailService;

    @PostMapping("/login")
    public boolean login(String credential, String pass) {
        Profile profile = profileClient.findProfile(credential);
        if (profile == null) return false;

        Optional<User> optUser = userRepository.findById(profile.getId());
        User user = optUser.get();
        return validatePass(user.getHashPass(),pass);
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
    public boolean changePass(String newPass, String resetCode) {
        Profile profile = profileClient.findUserByResetToken(resetCode);
        if (profile == null) return false;

        Optional<User> optUser = userRepository.findById(profile.getId());
        User user = optUser.get();
        user.setHashPass(String.valueOf(newPass.hashCode()));
        userRepository.save(user);

        profile.setResetToken(null);
        profileClient.updateUser(profile);

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

    private boolean validatePass(String hashPass, String inputPass){
        return (hashPass.equals(String.valueOf(inputPass.hashCode())));
    }
}
