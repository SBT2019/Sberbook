package ru.sberbook.sberbookroot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.UUID;

@Entity
public class SubscribtionsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long subscriptionId;

    protected SubscribtionsEntity(){
    }

    public SubscribtionsEntity(Long userId,Long subscriptionId){
        this.userId = userId;
        this.subscriptionId = subscriptionId;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, userId='%s', subscriptionId='%s']",
                id, userId, subscriptionId);
    }
}
