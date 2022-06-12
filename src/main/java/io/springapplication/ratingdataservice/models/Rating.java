package io.springapplication.ratingdataservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Document(collection = "movieRatings")
public class Rating {

    @Id
    private String movieId;
    private long avgRating;
    private List<UserRatingReview> userReview;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public long getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(long avgRating) {
        this.avgRating = avgRating;
    }

    public List<UserRatingReview> getUserReview() {
        return userReview;
    }

    public void setUserReview(List<UserRatingReview> userReview) {
        this.userReview = userReview;
    }
}
