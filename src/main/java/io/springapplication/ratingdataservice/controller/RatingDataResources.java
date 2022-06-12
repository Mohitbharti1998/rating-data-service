package io.springapplication.ratingdataservice.controller;


import io.springapplication.ratingdataservice.models.Rating;
import io.springapplication.ratingdataservice.models.UserRating;
import io.springapplication.ratingdataservice.repositroy.RatingRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResources {

    @Autowired
    public RatingRepositroy ratingRepositroy;

    @Autowired
    public UserRating userRating;

    @GetMapping("/count")
    public int getAllRating(){

        return ratingRepositroy.findAll().size();
    }

    @GetMapping("/fetchAll")
    public String getAll(){

        userRating.setUserRating(ratingRepositroy.findAll());

        return userRating.getUserRating().toString();
    }

    @RequestMapping("/findById/{movieId}")
    public Optional<Rating> getRating(@PathVariable("movieId") String movieId) {
         Optional<Rating> rating = ratingRepositroy.findById(movieId);

         if(rating.isPresent()){

         }
        return rating;
    }


    @RequestMapping(value = "/insert")
    public Rating insertUserRating(@RequestBody Rating insert){
        ratingRepositroy.insert(insert);
        return insert;
    }




}
