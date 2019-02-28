package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SubscriptionController {
    @GetMapping("/getAllSubscriptions")
    public List<Long> getAllSubscriptions(long userId) {
        return Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    }

    @GetMapping("/addSubscription")
    public void addSubscription(long userId, Object subscription) {
    }

    @GetMapping("/deleteSubscription")
    public void deleteSubscription(long userId, long subscriptionId) {
    }
}


