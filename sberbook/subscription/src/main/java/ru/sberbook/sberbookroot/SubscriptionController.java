package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubscriptionController {
    final SubscriptionService service;

    public SubscriptionController(SubscriptionService service){
        this.service = service;
    }

    @GetMapping("/getAllSubscriptions")
    public List<Long> getAllSubscriptions(String userId) {
        return service.getAllSubscriptions(userId);
    }

    @GetMapping("/getAllSubscribers")
    public List<Long> getAllSubscribers(String userId) {
        return service.getAllSubscribers(userId);
    }

    @GetMapping("/addSubscription")
    public void addSubscription(String userId, String subscriptionId) {
        service.addSubscription(userId,subscriptionId);
    }

    @GetMapping("/addSubscriber")
    public void addSubscriber(String userId, String subscriberId) {
        service.addSubscriber(userId,subscriberId);
    }

    @GetMapping("/deleteSubscription")
    public void deleteSubscription(String userId, String subscriptionId) {
        service.deleteSubscription(userId, subscriptionId);
    }

    @GetMapping("/deleteSubscriber")
    public void deleteSubscriber(String userId, String subscriberId) {
        service.deleteSubscriber(userId,subscriberId);
    }
}


