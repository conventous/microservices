package nl.fontys.tweetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TweetserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetserviceApplication.class, args);
	}

}
