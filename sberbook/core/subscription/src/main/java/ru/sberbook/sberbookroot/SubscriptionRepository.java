package ru.sberbook.sberbookroot;

        import org.springframework.data.repository.CrudRepository;

        import java.util.List;

public interface SubscriptionRepository extends CrudRepository<SubscribtionsEntity,Long> {

    List<SubscribtionsEntity> findByUserId(Long userId);

    void deleteSubscribtionsEntityByUserIdAndSubscriptionId(Long userId, Long subscriptionId);
}
