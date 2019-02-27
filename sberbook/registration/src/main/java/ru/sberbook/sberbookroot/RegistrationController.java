package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class RegistrationController {

    @GetMapping("/registration")
    public boolean registerUserAccount(ArrayList<String> credentials, String pass) {
        if (!checkUserForExistence(credentials)){
            //creating user in cache
            //redirecting -> /confirmation
            return true;
        }
        return false;
    }

    @GetMapping("/confirmation")
    public boolean confirmation(ArrayList<String> credentials, String pass, int code){
        if (code == 1) {
            //creating User in db
            return true;
        }
        return false; //redirecting to -> /registration
    }

    private boolean checkUserForExistence(ArrayList<String> credentials){
        for (String credential: credentials ) {
            if (checkUserByCredential(credential)) return true;
        }
        return false;
    }

    private boolean checkUserByCredential(String credential){
        //request to host:9000/getUserId?credential=credential
        Random random = new Random();
        if (random.nextInt(5)%2 == 0) return true;
        return false;
    }




}
