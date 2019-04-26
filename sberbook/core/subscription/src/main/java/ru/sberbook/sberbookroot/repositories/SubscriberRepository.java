package ru.sberbook.sberbookroot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbook.sberbookroot.entities.SubscribersEntity;

import java.util.List;

@Repository
public interface SubscriberRepository extends CrudRepository<SubscribersEntity, Long> {

    List<SubscribersEntity> findByUserId(Long userId);

    SubscribersEntity findSubscribersEntityByUserIdAndSubscriberId(Long userId, Long subscriberId);
}
