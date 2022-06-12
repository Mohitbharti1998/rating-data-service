package io.springapplication.ratingdataservice.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRating {

    private List<Rating> userRating;


    public List<Rating> getUserRating() {
        return userRating;
    }


    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }


}
