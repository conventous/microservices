package nl.fontys.tweetservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") //zuul redirect hierna toe
public class TweetController {

    @GetMapping
    public String helloWorld(){
        return "hellworld from tweetcontroller";
    }
}
