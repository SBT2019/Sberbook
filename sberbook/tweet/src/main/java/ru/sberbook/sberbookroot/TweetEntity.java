package ru.sberbook.sberbookroot;

import java.util.List;

public class TweetEntity {
    private final long userId;
    private final long tweetId;
    private final List<Long> childId;
    private final Long parentId;
    private final String text = "It's test tweet";

    TweetEntity(long userId, long tweetId, List<Long> childId, Long parentId) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.childId = childId;
        this.parentId = parentId;
    }

    public long getChildCount() {
        return childId.size();
    }

    public long getUserId() {
        return userId;
    }

    public long getTweetId() {
        return tweetId;
    }

    public List<Long> getChildId() {
        return childId;
    }

    public String getText() {
        return text;
    }

    public Long getParentId() {
        return parentId;
    }
}
