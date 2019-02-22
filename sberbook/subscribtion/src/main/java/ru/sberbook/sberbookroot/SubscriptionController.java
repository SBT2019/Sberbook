package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SubscriptionController {
    @GetMapping("/getSubscription")
    public List<Long> getSubscription(long userId) {
        return Arrays.asList(1L, 2L, 3L);
    }
}
