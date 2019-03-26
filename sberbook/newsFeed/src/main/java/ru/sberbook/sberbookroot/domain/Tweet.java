package ru.sberbook.sberbookroot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tweet {
    @Id
    @GeneratedValue
    private long tweetId;
    private long userId;
    private String text;
    private String tag;

    public Tweet() {
        this.userId = -1;
        this.text = "No text";
        this.tag = "No tag";
    }

    public Tweet(long userId, String text, String tag) {
        this.userId = userId;
        this.text = text;
        this.tag = tag;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
