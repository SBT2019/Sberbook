package ru.sberbook.sberbookroot;

import reactor.core.publisher.Flux;
import ru.sberbook.sberbookroot.entities.SubscribersEntity;
import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;

import java.util.List;

public interface SubscriptionService {
    //Flux<Long> getAllSubscriptions(long userId);
    List<SubscribtionsEntity> getAllSubscriptions(long userId);

    List<SubscribersEntity> getAllSubscribers(long userId);

    void addSubscription(String userId, String subscriptionId);

    void addSubscriber(String userId, String subscriberId);

    void deleteSubscription(String userId, String subscriptionId);

    void deleteSubscriber(String userId, String subscriberId);
}
