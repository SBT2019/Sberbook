package ru.sberbook.sberbookroot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.sberbook.sberbookroot.entities.SubscribersEntity;
import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;
import ru.sberbook.sberbookroot.repositories.SubscriberRepository;
import ru.sberbook.sberbookroot.repositories.SubscriptionRepository;

import java.util.List;

import static java.util.stream.LongStream.range;
import static reactor.core.publisher.Flux.fromStream;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private final SubscriptionRepository subscriptionRepository;
    @Autowired
    private final SubscriberRepository subscriberRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, SubscriberRepository subscriberRepository){
        this.subscriptionRepository = subscriptionRepository;
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public Flux<Long> getAllSubscriptions(long userId) {
        return fromStream(range(0, 100_000)
                .mapToObj(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    return 123456789L;
                })
        );
    }

    @Override
    public List<SubscribtionsEntity> getAllSubscribers(long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    @Override
    public void addSubscription(String userId, String subscriptionId) {
        subscriptionRepository.save(new SubscribtionsEntity(Long.parseLong(userId),Long.parseLong(subscriptionId)));
    }

    @Override
    public boolean addSubscriber(String userId, String subscriberId) {
        subscriberRepository.save(new SubscribersEntity(Long.parseLong(userId),Long.parseLong(subscriberId)));
        return true;
    }

    @Override
    public void deleteSubscription(String userId, String subscriptionId) {
        subscriptionRepository.deleteSubscribtionsEntityByUserIdAndSubscriptionId(Long.parseLong(userId),Long.parseLong(subscriptionId));

    }

    @Override
    public void deleteSubscriber(String userId, String subscriberId) {
        subscriberRepository.deleteSubscribersEntityByUserIdAndSubscriberId(Long.parseLong(userId),Long.parseLong(subscriberId));
    }
}
