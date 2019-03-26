package ru.sberbook.sberbookroot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sberbook.sberbookroot.domain.Tweet;
import ru.sberbook.sberbookroot.repo.TweetsRepo;


@Controller
public class NewsFeedController {
    private final TweetsRepo tweetsRepo;

    public NewsFeedController(TweetsRepo tweetsRepo) {
        this.tweetsRepo = tweetsRepo;
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Tweet> tweets;

        if (filter != null && !filter.isEmpty()) {
            tweets = tweetsRepo.findTweetsByTag(filter);
        } else {
            tweets = tweetsRepo.findAll();
        }

        model.addAttribute("tweets", tweets);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(String text,
                      String tag, Model model) {
        if (text != null && tag != null) {
            Tweet tweet = new Tweet(1, text, tag);
            tweetsRepo.save(tweet);
        }

        Iterable<Tweet> tweets = tweetsRepo.findAll();
        model.addAttribute("tweets", tweets);
        return "main";
    }
}
