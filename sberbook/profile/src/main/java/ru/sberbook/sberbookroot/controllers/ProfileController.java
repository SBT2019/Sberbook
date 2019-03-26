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
    public boolean createUser(@RequestBody ProfileDto profileDto) { //todo: check profileDto name
        try {
            return profileService.createUser(profileDto);
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/findUser")
    public Profile findProfile(String credential) {
        return profileService.findProfile(credential);
    }
}

//    @RequestMapping("/updateUser")
//    boolean updateUser(@RequestParam("profile") Profile profile);
//
//    @RequestMapping("/findUserByResetToken")
//    Profile findUserByResetToken(@RequestParam("token") String token);
//
//    @RequestMapping("/checkUser")
//    boolean checkProfile(@RequestParam("credential") String credential);
//
//    @RequestMapping("/findUserByConfirmationCode")
//    Profile findUserByConfirmationCode(@RequestParam("confirmationCode") String confirmationCode);
