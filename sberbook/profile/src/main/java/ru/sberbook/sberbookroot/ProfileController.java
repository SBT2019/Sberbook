package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @GetMapping("/getUserId")
    public long getUserId(String credential) {
        if (isEmail(credential)) return 7;
        if (isPhone(credential)) return 15;
        return 40;
    }

    private boolean isPhone(String credential) {
        return true;
    }

    private boolean isEmail(String credential) {
        return credential.contains("@");
    }

}
