package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubscriptionController {
    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service){
        this.service = service;
    }

    @GetMapping("/getAllSubscriptions")
    public List<Long> getAllSubscriptions(long userId) {
        return service.getAllSubscriptions(userId);
    }

    @GetMapping("/getAllSubscribers")
    public List<Long> getAllSubscribers(long userId) {
        return service.getAllSubscribers(userId);
    }

    @PostMapping("/addSubscription")
    public void addSubscription(String userId, String subscriptionId) {
        service.addSubscription(userId,subscriptionId);
    }

    @PostMapping("/addSubscriber")
    public void addSubscriber(String userId, String subscriberId) {
        service.addSubscriber(userId,subscriberId);
    }

    @PostMapping("/deleteSubscription")
    public void deleteSubscription(String userId, String subscriptionId) {
        service.deleteSubscription(userId, subscriptionId);
    }

    @PostMapping("/deleteSubscriber")
    public void deleteSubscriber(String userId, String subscriberId) {
        service.deleteSubscriber(userId,subscriberId);
    }
}


