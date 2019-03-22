package ru.sberbook.sberbookroot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbook.sberbookroot.service.ProfileService;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

//    @RequestMapping("/createUser")
//    boolean createUser(@RequestParam("profile") Profile profile);

//    @RequestMapping("/findUser")
//    Profile findProfile(@RequestParam("credential") String credential);
}




//    @RequestMapping("/updateUser")
//    boolean updateUser(@RequestParam("profile") Profile profile);
//
//    @RequestMapping("/findUserByResetToken")
//    Profile findUserByResetToken(@RequestParam("token") String token);
//
//
//    @RequestMapping("/checkUser")
//    boolean checkProfile(@RequestParam("credential") String credential);
//
//    @RequestMapping("/findUserByConfirmationCode")
//    Profile findUserByConfirmationCode(@RequestParam("confirmationCode") String confirmationCode);
