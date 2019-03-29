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

    @GetMapping("/getUserId")
    public long getUserId(String credential) {
        if (isEmail(credential)) return 7;
        if (isPhone(credential)) return 15;
        return 40;
    }

//    @GetMapping("/findUser")
//    public Profile findUser(String credential) {
//        if (isEmail(credential)) return new Profile("Alex", "gfdgdfgdf");
//        if (isPhone(credential)) return new Profile("Dima", "gfdgdfgdf");;
//
//        return new Profile("Dasha", "FSDGFDGDF");
//    }
//
//    @PostMapping("/createUser")
//    public boolean createUser(Profile profile) {
//        //TODO add user to cash
//        return true;
//    }

    @GetMapping("/checkUser")
    public boolean checkUser(String credential) {
        if (isEmail(credential)) return true; //TODO find user by email
        if (isPhone(credential)) return true; //TODO find user by phone

        return false;
    }

    @PostMapping("/addUser")
    public boolean addUser(Profile profile) {
        //TODO add user to db
        return true;
    }

    @GetMapping("/findUserByConfirmationCode") //TODO ?
    public Profile findUserByConfirmationCode(String confirmationCode){
        return new Profile("Roma","gfdgdfgdf"); //in cache
    }

    @GetMapping("/findUserByResetToken") //TODO ?
    public Profile findUserByResetToken(String token){
        return new Profile("Roma","gfdgdfgdf");
    }

    @PostMapping("/updateUser")
    public boolean updateUser(Profile profile){
        return true;
    }


    private boolean isPhone(String credential) {
        return true;
    }

    private boolean isEmail(String credential) {
        return credential.contains("@");
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
