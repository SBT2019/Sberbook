package ru.sberbook.feed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.sberbook.feed.client.SubscriptionClient;
import ru.sberbook.feed.client.Tweet;
import ru.sberbook.feed.client.TweetsClient;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;


@RestController
public class FeedController {
    @Autowired
    private SubscriptionClient subscriptionClient;
    @Autowired
    private TweetsClient tweetsClient;
    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping("/getFeed")
    public Feed getFeed(long userId) {
        List<Long> subscription = subscriptionClient.getAllSubscriptions(userId);
        List<Tweet> tweets = tweetsClient.findTweetsByUserIds(subscription);

        Flux<Tweet> tweetFlux = WebClient.create("http://tweet")
                .get()
                .uri("/getTweetsByUserIds/{userIds}", subscription)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Tweet.class);

        return new Feed(tweets);
    }

    @GetMapping(value = "/tweets", produces = APPLICATION_STREAM_JSON_VALUE)
    public Flux<Tweet> tweets(long userId) {
        return webClientBuilder.build()
                .get()
                .uri("http://tweet/getTweetsByUserIds?userId=" + userId)
                .retrieve()
                .bodyToFlux(Tweet.class);
    }
}
