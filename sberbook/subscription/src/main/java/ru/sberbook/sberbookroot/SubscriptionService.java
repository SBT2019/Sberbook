package ru.sberbook.sberbookroot;

import java.util.List;

public interface SubscriptionService {
    List<Long> getAllSubscriptions(long userId);

    List<Long> getAllSubscribers(long userId);

    void addSubscription(String userId, String subscriptionId);

    void addSubscriber(String userId, String subscriberId);

    void deleteSubscription(String userId, String subscriptionId);

    void deleteSubscriber(String userId, String subscriberId);
}
