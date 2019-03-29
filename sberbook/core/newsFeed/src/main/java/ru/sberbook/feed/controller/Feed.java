package ru.sberbook.feed.controller;

import ru.sberbook.feed.client.Tweet;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Feed {
    private String tweets;

    public Feed(List<Tweet> tweets) {
        this.tweets = tweets.stream()
                .map(Tweet::getText)
                .collect(joining(","));
    }

    public String getTweets() {
        return tweets;
    }
}
