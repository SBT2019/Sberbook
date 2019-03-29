package ru.sberbook.feed.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "subscription", url = "${subscription.url}")
public interface SubscriptionClient {
    @RequestMapping("getAllSubscriptions")
    List<Long> getAllSubscriptions(@RequestParam("userId") long userId);
}
