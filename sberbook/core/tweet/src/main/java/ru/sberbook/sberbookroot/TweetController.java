package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

@RestController
public class TweetController {
    @GetMapping("/getTweetsByUserId")
    public List<TweetEntity> getTweetsByUserId(long userId) {
        //Finding list of tweetId by userId
        //Getting tweets by list of tweetId

        if (userId <= 0L) return emptyList();

        return asList(
                new TweetEntity(userId, 123, emptyList(), null),
                new TweetEntity(userId, 124, asList(555L, 444L), 345L)
        );
    }

    @GetMapping("/getTweetsByUserIds")
    public List<TweetEntity> getTweetsByUserId(long[] userIds) {
        return asList(
                new TweetEntity(23, 123, emptyList(), null),
                new TweetEntity(3, 124, asList(555L, 444L), 345L)
        );
    }

    @GetMapping("/getTweetByTweetId")
    public TweetEntity getTweetByTweetId(long tweetId) {
        //Getting tweet by tweetId
        return tweetId > 0L ? new TweetEntity(111, tweetId, emptyList(), 234L) : null;
    }

    @GetMapping("/getComments")
    public List<TweetEntity> getComments(long tweetId) {
        //Finding tweet by tweetId
        //Getting list of childId
        //Finding tweets by list of childId
        if (tweetId <= 0L) return emptyList();

        return asList(
                new TweetEntity(122, 155, asList(111L), tweetId),
                new TweetEntity(125, 177, emptyList(), tweetId)
        );
    }

}
