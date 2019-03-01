package ru.sberbook.sberbookroot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TweetController {

    @GetMapping("/getTweetsByUserId")
    public List<TweetEntity> getTweetsByUserId(long userId) {
        //Finding list of tweetId by userId
        //Getting tweets by list of tweetId
        if (userId > 0L) {
            return Arrays.asList(new TweetEntity(userId, 123, null, null), new TweetEntity(userId, 124, Arrays.asList(555L, 444L), 345L));
        }
        return Arrays.asList(null);
    }

    @GetMapping("/getTweetByTweetId")
    public TweetEntity getTweetByTweetId(long tweetId) {
        //Getting tweet by tweetId
        if (tweetId > 0L) {
            return new TweetEntity(111, tweetId, null, 234L);
        }
        return null;
    }

    @GetMapping("/getComments")
    public List<TweetEntity> getComments(long tweetId) {
        //Finding tweet by tweetId
        //Getting list of childId
        //Finding tweets by list of childId
        if (tweetId > 0L) {
            return Arrays.asList(new TweetEntity(122, 155, Arrays.asList(111L), tweetId), new TweetEntity(125, 177, null, tweetId));
        }
        return Arrays.asList(null);
    }

}
