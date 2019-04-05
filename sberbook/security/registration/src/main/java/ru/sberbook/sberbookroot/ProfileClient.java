package ru.sberbook.sberbookroot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Violetta on 2019-03-20
 */
@FeignClient(name = "profile")
public interface ProfileClient {
    @RequestMapping("/checkUser")
    boolean checkProfile(@RequestParam("credential") String credential);

    @RequestMapping(value = "/createUser", method = POST)
    boolean createUser(@RequestParam("profile") Profile profile);

    @RequestMapping("/findUserByConfirmationCode")
    Profile findUserByConfirmationCode(@RequestParam("confirmationCode") String confirmationCode);

    @RequestMapping(value = "/addUser", method = POST)
    boolean addUser(@RequestParam("profile") Profile profile);
}
