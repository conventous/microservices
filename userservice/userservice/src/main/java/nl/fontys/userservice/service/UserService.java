package nl.fontys.userservice.service;

import nl.fontys.tweetservice.domain.Tweet;
import nl.fontys.userservice.dao.TweetRepo;
import nl.fontys.userservice.dao.UserRepo;
import nl.fontys.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo; //Local in-memory h2 database

    @Autowired
    private TweetRepo tweetRepo; //Sends requests to Tweet Microservice REST API

    public User getUser(String username){
        User user = this.userRepo.findByUsername(username);

        //If user exists, retrieve its tweets from tweet Microservice
        if(user != null){
            List<Tweet> userTweets = this.tweetRepo.getUserTweets(user.getId());

            user.setTweets(userTweets);
        }

        return user;
    }

    public void newUser(User user){
        this.userRepo.save(user);
    }
}
