package ru.sberbook.feed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbook.feed.client.SubscriptionClient;
import ru.sberbook.feed.client.Tweet;
import ru.sberbook.feed.client.TweetsClient;

import java.util.List;


@RestController
public class FeedController {
    private final SubscriptionClient subscriptionClient;
    private final TweetsClient tweetsClient;

    public FeedController(SubscriptionClient subscriptionClient, TweetsClient tweetsClient) {
        this.subscriptionClient = subscriptionClient;
        this.tweetsClient = tweetsClient;
    }

    @GetMapping("/getFeed")
    public Feed getFeed(long userId) {
        List<Long> subscription = subscriptionClient.getAllSubscriptions(userId);
        List<Tweet> tweets = tweetsClient.findTweetsByUserIds(subscription);

        return new Feed(tweets);
    }
}
