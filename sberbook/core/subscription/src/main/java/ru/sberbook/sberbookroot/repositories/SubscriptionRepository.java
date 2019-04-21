package ru.sberbook.sberbookroot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;

import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscribtionsEntity,Long> {

    List<SubscribtionsEntity> findByUserId(Long userId);

    void deleteSubscribtionsEntityByUserIdAndSubscriptionId(Long userId, Long subscriptionId);
}
