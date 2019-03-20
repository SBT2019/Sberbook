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

    @GetMapping("/findUser")
    public Profile findUser(String credential) {
        if (isEmail(credential)) return new Profile("Alex", "gfdgdfgdf");
        if (isPhone(credential)) return new Profile("Dima", "gfdgdfgdf");;

        return new Profile("Dasha", "FSDGFDGDF");
    }

    @GetMapping("/createUser")
    public boolean createUser(Profile profile) {
        //TODO add user to cash
        return true;
    }

    @GetMapping("/checkUser")
    public boolean checkUser(String credential) {
        if (isEmail(credential)) return true; //TODO find user by email
        if (isPhone(credential)) return true; //TODO find user by phone

        return false;
    }

    @GetMapping("/addUser")
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

    @GetMapping("/updateUser")
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
