package ru.sberbook.sberbookroot.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbook.sberbookroot.dto.ProfileDto;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.service.ProfileService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/createUser")
    public boolean createUser(@RequestBody ProfileDto profileDto) {
        try {
            return profileService.createUser(profileDto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findUser")
    public Profile findProfile(String credential) {
        return profileService.findProfile(credential);
    }

    @GetMapping("/getUserId")
    public long getUserId(String credential) {
        try {
            return profileService.getUserId(credential);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @GetMapping("/checkUser")
    public boolean checkUser(String credential) {
        try {
            return profileService.checkUser(credential);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findUserByConfirmationCode")
    public Profile findUserByConfirmationCode(String confirmationCode){
        try {
            return profileService.findUserByConfirmationCode(confirmationCode);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/findUserByResetToken")
    public Profile findUserByResetToken(String token){
        try {
            return profileService.findUserByToken(token);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
