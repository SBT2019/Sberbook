package ru.sberbook.sberbookroot;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionsRepository subscriptionsRepository;
    private final  SubscribersRepository subscribersRepository;

    public SubscriptionServiceImpl(SubscriptionsRepository subscriptionsRepository, SubscribersRepository subscribersRepository){
        this.subscriptionsRepository = subscriptionsRepository;
        this.subscribersRepository = subscribersRepository;
    }

    @Override
    public List<Long> getAllSubscriptions(long userId) {
        return Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    }

    @Override
    public List<Long> getAllSubscribers(long userId) {
        return Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    }

    @Override
    public void addSubscription(String userId, String subscriptionId) {
    }

    @Override
    public void addSubscriber(String userId, String subscriberId) {
    }

    @Override
    public void deleteSubscription(String userId, String subscriptionId) {
    }

    @Override
    public void deleteSubscriber(String userId, String subscriberId) {
    }
}
