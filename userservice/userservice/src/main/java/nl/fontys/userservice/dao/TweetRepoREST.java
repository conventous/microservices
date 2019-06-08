package nl.fontys.userservice.dao;

import nl.fontys.tweetservice.domain.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class TweetRepoREST implements TweetRepo {

    @Autowired
    private RestTemplate restTemplate;

    private final String urlTweetservice = "http://tweet-service";

    @Override
    public List<Tweet> getUserTweets(int userID) {
        //Headers, accept json response
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        //Construct uri with parameter
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlTweetservice +"/getusertweets")
                .queryParam("userID", userID);
        String uriString = builder.toUriString();

        //Create request and send request
        ResponseEntity<List<Tweet>> response = restTemplate.exchange(
                uriString,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Tweet>>(){});

        return response.getBody();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
