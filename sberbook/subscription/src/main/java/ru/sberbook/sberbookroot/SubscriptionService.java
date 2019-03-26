package ru.sberbook.sberbookroot;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionsRepository subscriptionsRepository;
    private final  SubscribersRepository subscribersRepository;

    public SubscriptionService(SubscriptionsRepository subscriptionsRepository,SubscribersRepository subscribersRepository){
        this.subscriptionsRepository = subscriptionsRepository;
        this.subscribersRepository = subscribersRepository;
    }

    public List<Long> getAllSubscriptions(String userId) {
        return Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    }

    public List<Long> getAllSubscribers(String userId) {
        return Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    }

    public void addSubscription(String userId, String subscriptionId) {
    }

    public void addSubscriber(String userId, String subscriberId) {
    }

    public void deleteSubscription(String userId, String subscriptionId) {
    }

    public void deleteSubscriber(String userId, String subscriberId) {
    }
}
