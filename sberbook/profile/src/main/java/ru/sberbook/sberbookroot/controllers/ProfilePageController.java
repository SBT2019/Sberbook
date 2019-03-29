package ru.sberbook.sberbookroot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilePageController {
    @GetMapping("/profile")
    public String profilePage() {
        return "index";
    }
}
