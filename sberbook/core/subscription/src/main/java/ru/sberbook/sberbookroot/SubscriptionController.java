package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubscriptionController {
    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @GetMapping("/getAllSubscriptions")
    public List<Long> getAllSubscriptions(long userId) {
        try {
            return service.getAllSubscriptions(userId);
        } catch (Exception e) {
            System.out.println("Ошибка при получении списка подписок");
            throw e;
        }
    }

    @GetMapping("/getAllSubscribers")
    public List<Long> getAllSubscribers(long userId) {
        try {
            return service.getAllSubscribers(userId);
        } catch (Exception e) {
            System.out.println("Ошибка при получении списка подписчиков");
            throw e;
        }
    }

    @PostMapping("/addSubscription")
    public void addSubscription(String userId, String subscriptionId) {
        try {
            service.addSubscription(userId, subscriptionId);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении подписки");
            throw e;
        }
    }

    @PostMapping("/addSubscriber")
    public void addSubscriber(String userId, String subscriberId) {
        try {
            service.addSubscriber(userId, subscriberId);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении подписчика");
            throw e;
        }
    }

    @PostMapping("/deleteSubscription")
    public void deleteSubscription(String userId, String subscriptionId) {
        try {
            service.deleteSubscription(userId, subscriptionId);
        } catch (Exception e) {
            System.out.println("Ошибка при удалении подписки");
            throw e;
        }
    }

    @PostMapping("/deleteSubscriber")
    public void deleteSubscriber(String userId, String subscriberId) {
        try {
            service.deleteSubscriber(userId, subscriberId);
        } catch (Exception e) {
            System.out.println("Ошибка при удалении подписчика");
            throw e;
        }
    }
}


