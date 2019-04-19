package ru.sberbook.sberbookroot.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbook.sberbookroot.entities.SubscribersEntity;
import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;

import java.util.List;

public interface SubscriberRepository extends CrudRepository<SubscribersEntity,Long> {
    List<SubscribtionsEntity> findByUserId(Long userId);

    void deleteSubscribersEntityByUserIdAndSubscriberId(Long userId, Long subscriberId);
}
