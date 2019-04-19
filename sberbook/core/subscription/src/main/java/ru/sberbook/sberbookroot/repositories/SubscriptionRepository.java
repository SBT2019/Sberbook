package ru.sberbook.sberbookroot.repositories;

        import org.springframework.data.repository.CrudRepository;
        import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;

        import java.util.List;

public interface SubscriptionRepository extends CrudRepository<SubscribtionsEntity,Long> {

    List<SubscribtionsEntity> findByUserId(Long userId);

    void deleteSubscribtionsEntityByUserIdAndSubscriptionId(Long userId, Long subscriptionId);
}
