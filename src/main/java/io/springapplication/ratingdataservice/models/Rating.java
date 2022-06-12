package io.springapplication.ratingdataservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "movieRatings")
public class Rating {

    @Id
    private String movieId;
    private int rating;

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }


    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
