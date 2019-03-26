package ru.sberbook.feed.client;


public class Tweet {
    private long tweetId;
    private long userId;
    private String text;

    public Tweet() {
        this.userId = -1;
        this.text = "No text";
    }

    public Tweet(long userId, String text, String tag) {
        this.userId = userId;
        this.text = text;
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

}
