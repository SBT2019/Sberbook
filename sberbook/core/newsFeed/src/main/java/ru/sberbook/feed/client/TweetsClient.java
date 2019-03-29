package ru.sberbook.feed.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "tweet")
public interface TweetsClient {
    @RequestMapping("getTweetsByUserIds")
    List<Tweet> findTweetsByUserIds(@RequestParam("userIds") List<Long> userIds);
}
