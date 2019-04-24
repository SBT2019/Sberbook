package ru.sberbook.sberbookroot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscribtionsEntity, Long> {

    List<SubscribtionsEntity> findByUserId(Long userId);

    void deleteSubscribtionsEntityByUserIdAndSubscriptionId(Long userId, Long subscriptionId);
}
