package ru.sberbook.sberbookroot.entities;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "SUBSCRIBERS")
public class SubscribersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long subscriberId;

    protected SubscribersEntity() {
    }

    public SubscribersEntity(Long userId, Long subscriberId) {
        this.userId = userId;
        this.subscriberId = subscriberId;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, userId='%s', subscriberId='%s']",
                id, userId, subscriberId);
    }
}
