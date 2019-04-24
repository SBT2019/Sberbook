package ru.sberbook.sberbookroot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbook.sberbookroot.entities.SubscribersEntity;
import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;

import java.util.List;

@RestController
public class SubscriptionController {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionController.class);
    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @GetMapping("/getAllSubscriptions")
    public List<SubscribtionsEntity> getAllSubscriptions(long userId) {
        try {
            return service.getAllSubscriptions(userId);
        } catch (Exception e) {
            log.info("Ошибка при получении списка подписчиков" + e);
            throw e;
        }
    }

    @GetMapping("/getAllSubscribers")
    public List<SubscribersEntity> getAllSubscribers(long userId) {
        try {
            return service.getAllSubscribers(userId);
        } catch (Exception e) {
            log.info("Ошибка при получении списка подписчиков" + e);
            throw e;
        }
    }

    @PostMapping("/addSubscription")
    public void addSubscription(String userId, String subscriptionId) {
        try {
            service.addSubscription(userId, subscriptionId);
        } catch (Exception e) {
            log.info("Ошибка при добавлении подписки" + e);
        }
    }

    @PostMapping("/addSubscriber")
    public void addSubscriber(String userId, String subscriberId) {
        try {
            service.addSubscriber(userId, subscriberId);
        } catch (Exception e) {
            log.info("Ошибка при добавлении подписчика" + e);
        }
    }

    @PostMapping("/deleteSubscription")
    public void deleteSubscription(String userId, String subscriptionId) {
        try {
            service.deleteSubscription(userId, subscriptionId);
        } catch (Exception e) {
            log.info("Ошибка при удалении подписки" + e);
        }
    }

    @PostMapping("/deleteSubscriber")
    public void deleteSubscriber(String userId, String subscriberId) {
        try {
            service.deleteSubscriber(userId, subscriberId);
        } catch (Exception e) {
            log.info("Ошибка при удалении подписчика" + e);
        }
    }
}


