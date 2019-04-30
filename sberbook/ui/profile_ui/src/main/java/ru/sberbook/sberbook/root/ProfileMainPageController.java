package ru.sberbook.sberbook.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileMainPageController {

    @GetMapping("/profile")
    public String getPage() {
        return "index";
    }
}
