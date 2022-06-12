package io.springapplication.ratingdataservice;

import io.springapplication.ratingdataservice.models.UserRating;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RatingDataServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceApplication.class, args);
	}

}
