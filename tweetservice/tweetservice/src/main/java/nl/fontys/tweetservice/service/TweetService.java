package nl.fontys.tweetservice.service;

import nl.fontys.tweetservice.dao.TweetRepo;
import nl.fontys.tweetservice.domain.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TweetService {

    @Autowired
    private TweetRepo tweetRepo;

    public void newTweet(Tweet tweet){
        this.tweetRepo.save(tweet);
    }

    public List<Tweet> getUserTweets(int userID){return this.tweetRepo.findByUserID(userID);}
}
