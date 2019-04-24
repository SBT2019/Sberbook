package ru.sberbook.sberbookroot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbook.sberbookroot.entities.SubscribersEntity;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscribersEntity, Long> {
    List<SubscribersEntity> findByUserId(Long userId);

    void deleteSubscribersEntityByUserIdAndSubscriberId(Long userId, Long subscriberId);
}
