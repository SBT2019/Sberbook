package ru.sberbook.sberbookroot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.service.ProfileUiService;

@RestController
public class ProfileUiController {

    private final ProfileUiService profileUiService;

    @Autowired
    public ProfileUiController(ProfileUiService profileUiService) {
        this.profileUiService = profileUiService;
    }

    @GetMapping("/getProfileData")
    Profile getProfileData(String credential) {
        try {
            return profileUiService.getProfile(credential);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/setProfileData")
    Profile setProfileData(Profile profile) {
        try {
            return profileUiService.setProfile(profile);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
