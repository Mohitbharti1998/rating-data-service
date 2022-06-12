package io.springapplication.ratingdataservice.controller;


import com.mongodb.ErrorCategory;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import io.springapplication.ratingdataservice.models.Meta;
import io.springapplication.ratingdataservice.models.Rating;
import io.springapplication.ratingdataservice.models.UserRating;
import io.springapplication.ratingdataservice.repositroy.RatingRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResources {

    @Autowired
    public RatingRepositroy ratingRepositroy;

    @Autowired
    public UserRating userRating;


    @Autowired
    public Meta meta;

    @GetMapping("/count")
    public int getAllRating() {

        return ratingRepositroy.findAll().size();
    }

    @GetMapping("/fetchAll")
    public UserRating getAll() {
        userRating.setUserRating(ratingRepositroy.findAll());
        return userRating;
    }

    @RequestMapping("/findById/{movieId}")
    public Optional<Rating> getRating(@PathVariable("movieId") String movieId) {
        Optional<Rating> rating = ratingRepositroy.findById(movieId);

        if (rating.isPresent()) {

        }
        return rating;
    }


    @RequestMapping("/insert")
    public Meta insertUserRating(@RequestBody Rating insert) {
        List<Rating> rating = new ArrayList<>();
        try {
            rating.add(ratingRepositroy.insert(insert));
            meta.setStatus("success");
            meta.setData(rating);
            return meta;
        } catch (org.springframework.dao.DuplicateKeyException error) {
            rating.add(insert);
            meta.setStatus("fail");
            meta.setData(rating);
            return meta;
            }

        }
}