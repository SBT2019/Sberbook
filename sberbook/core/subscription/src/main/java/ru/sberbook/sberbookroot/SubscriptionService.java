package ru.sberbook.sberbookroot;

import reactor.core.publisher.Flux;

import java.util.List;

public interface SubscriptionService {
    Flux<Long> getAllSubscriptions(long userId);

    List<Long> getAllSubscribers(long userId);

    void addSubscription(String userId, String subscriptionId);

    void addSubscriber(String userId, String subscriberId);

    void deleteSubscription(String userId, String subscriptionId);

    void deleteSubscriber(String userId, String subscriberId);
}
