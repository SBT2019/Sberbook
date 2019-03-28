package ru.sberbook.sberbookroot;

import java.util.Collection;
import java.util.UUID;

public class Subscriptions {
    private UUID profileId;
    private Collection<UUID> subscribers;
    private Collection<UUID> subscriptions;

    public Subscriptions(String id){
        this.profileId = UUID.fromString(id);
    }
}
