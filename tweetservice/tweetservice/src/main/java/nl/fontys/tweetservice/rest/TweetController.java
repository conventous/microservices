package nl.fontys.tweetservice.rest;

import nl.fontys.tweetservice.domain.Tweet;
import nl.fontys.tweetservice.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/") //zuul redirect hierna toe
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @PostMapping(path = "/newtweet")
    public void newTweet(@RequestBody Tweet tweet){
        this.tweetService.newTweet(tweet);
    }

    @GetMapping(path = "/getusertweets")
    public List<Tweet> getUserTweets(@RequestParam int userID){
        return this.tweetService.getUserTweets(userID);
    }
}
