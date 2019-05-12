package ru.sberbook.sberbookroot;

import org.springframework.stereotype.Service;
import ru.sberbook.sberbookroot.entities.SubscribersEntity;
import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;
import ru.sberbook.sberbookroot.repositories.SubscriberRepository;
import ru.sberbook.sberbookroot.repositories.SubscriptionRepository;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriberRepository subscriberRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, SubscriberRepository subscriberRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public List<SubscribtionsEntity> getAllSubscriptions(long userId) {
        List<SubscribtionsEntity> entities = subscriptionRepository.findByUserId(userId);
        return entities;
    }

    @Override
    public List<SubscribersEntity> getAllSubscribers(long userId) {
        return subscriberRepository.findByUserId(userId);
    }

    @Override
    public void addSubscription(String userId, String subscriptionId) {
        subscriptionRepository.save(new SubscribtionsEntity(Long.parseLong(userId), Long.parseLong(subscriptionId)));
        subscriberRepository.save(new SubscribersEntity(Long.parseLong(subscriptionId), Long.parseLong(userId)));
    }

    @Override
    public void addSubscriber(String userId, String subscriberId) {
        subscriberRepository.save(new SubscribersEntity(Long.parseLong(userId), Long.parseLong(subscriberId)));
        subscriptionRepository.save(new SubscribtionsEntity(Long.parseLong(subscriberId), Long.parseLong(userId)));
    }

    @Override
    public void deleteSubscription(String userId, String subscriptionId) {
        subscriptionRepository.deleteById(subscriptionRepository.findSubscribtionsEntitiesByUserIdAndSubscriptionId(
                Long.parseLong(userId), Long.parseLong(subscriptionId)).getId());
        subscriberRepository.deleteById(subscriberRepository.findSubscribersEntityByUserIdAndSubscriberId(
                Long.parseLong(subscriptionId), Long.parseLong(userId)).getId());
    }

    @Override
    public void deleteSubscriber(String userId, String subscriberId) {
        subscriberRepository.deleteById(subscriberRepository.findSubscribersEntityByUserIdAndSubscriberId(
                Long.parseLong(userId), Long.parseLong(subscriberId)).getId());
        subscriptionRepository.deleteById(subscriptionRepository.findSubscribtionsEntitiesByUserIdAndSubscriptionId(
                Long.parseLong(subscriberId), Long.parseLong(userId)).getId());
    }
}
