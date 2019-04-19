package ru.sberbook.sberbookroot;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriberRepository extends CrudRepository<SubscribersEntity,Long> {
    List<SubscribtionsEntity> findByUserId(Long userId);

    void deleteSubscribersEntityByUserIdAndSubscriberId(Long userId, Long subscriberId);
}
