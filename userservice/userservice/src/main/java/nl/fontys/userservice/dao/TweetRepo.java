package nl.fontys.userservice.dao;

import nl.fontys.tweetservice.domain.Tweet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TweetRepo {
    List<Tweet> getUserTweets(int userID);
}
