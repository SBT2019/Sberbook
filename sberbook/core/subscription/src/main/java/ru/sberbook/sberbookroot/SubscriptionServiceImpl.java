package ru.sberbook.sberbookroot;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.LongStream.range;
import static reactor.core.publisher.Flux.fromStream;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionsRepository subscriptionsRepository;
    private final  SubscribersRepository subscribersRepository;

    public SubscriptionServiceImpl(SubscriptionsRepository subscriptionsRepository, SubscribersRepository subscribersRepository){
        this.subscriptionsRepository = subscriptionsRepository;
        this.subscribersRepository = subscribersRepository;
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
