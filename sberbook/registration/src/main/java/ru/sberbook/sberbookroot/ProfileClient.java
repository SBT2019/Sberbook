package ru.sberbook.sberbookroot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Violetta on 2019-03-20
 */
@FeignClient(name = "profile", url = "${profile-service.url}")
public interface ProfileClient {
    @RequestMapping("/checkUser")
    boolean checkProfile(@RequestParam("credential") String credential);

    @RequestMapping("/createUser")
    boolean createUser(@RequestParam("profile") Profile profile);

    @RequestMapping("/findUserByConfirmationCode")
    Profile findUserByConfirmationCode(@RequestParam("confirmationCode") String confirmationCode);

    @RequestMapping("/addUser")
    boolean addUser(@RequestParam("profile") Profile profile);

}
