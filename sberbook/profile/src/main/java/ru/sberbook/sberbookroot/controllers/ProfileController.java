package ru.sberbook.sberbookroot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sberbook.sberbookroot.dto.ProfileDto;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.response.UserResponce;
import ru.sberbook.sberbookroot.response.base.Response;
import ru.sberbook.sberbookroot.response.base.ResponseWrapper;
import ru.sberbook.sberbookroot.service.ProfileService;

import static ru.sberbook.sberbookroot.response.base.ResponseBuilder.render;

@RestController
public class ProfileController {

    private final ProfileService profileService;
    Logger LOG = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<ResponseWrapper> createUser(@RequestBody ProfileDto profileDto) { //todo: check profileDto name
        LOG.info("Create user request");
        Response response;
        Boolean profileCreated;
        try {
            profileCreated = profileService.createUser(profileDto);
            response = UserResponce.USER_CREATION_SUCCESS;
            LOG.info("Add user response: " + profileCreated);
        } catch (Exception e) {
            profileCreated = false;
            response = UserResponce.USER_CREATION_FAILURE;
            LOG.error("Create user response failure: " + e.getMessage());
        }
        return render(profileCreated, response, HttpStatus.OK);
    }

    @GetMapping("/findUser")
    public ResponseEntity<ResponseWrapper> findProfile(@RequestParam String credential) {
        LOG.info("Find user request");
        Response response;
        Profile profile;
        try {
            profile = profileService.findProfile(credential);
            if (profile != null) {
                response = UserResponce.USER_FOUND;
                LOG.info("Find user response: " + profile.toString());
            } else {
                response = UserResponce.USER_NOT_FOUND;
                LOG.info("Find user response: " + profile.toString());
            }
        } catch (Exception e) {
            profile = null;
            response = UserResponce.USER_FINDING_ERROR;
            LOG.error("Find user response failure: " + e.getMessage());
        }
        return render(profile, response, HttpStatus.OK);
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
