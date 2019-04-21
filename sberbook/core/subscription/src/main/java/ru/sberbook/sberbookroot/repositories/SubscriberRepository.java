package ru.sberbook.sberbookroot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbook.sberbookroot.entities.SubscribersEntity;
import ru.sberbook.sberbookroot.entities.SubscribtionsEntity;

import java.util.List;

@Repository
public interface SubscriberRepository extends CrudRepository<SubscribersEntity,Long> {
    List<SubscribtionsEntity> findByUserId(Long userId);

    void deleteSubscribersEntityByUserIdAndSubscriberId(Long userId, Long subscriberId);
}
