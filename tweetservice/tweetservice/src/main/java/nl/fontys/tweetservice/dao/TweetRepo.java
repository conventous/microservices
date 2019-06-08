package nl.fontys.tweetservice.dao;

import nl.fontys.tweetservice.domain.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetRepo extends CrudRepository<Tweet, Integer> {
    List<Tweet> findByUserID(int userID);
}
