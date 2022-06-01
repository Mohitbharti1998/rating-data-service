package io.springapplication.ratingdataservice.resources;


import io.springapplication.ratingdataservice.models.Rating;
import io.springapplication.ratingdataservice.models.UserRating;
import io.springapplication.ratingdataservice.repositroy.RatingRepositroy;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResources {

    @Autowired
    public RatingRepositroy ratingRepositroy;

    @GetMapping("count")
    public List<Rating> getAllRating(){

        return ratingRepositroy.findAll();
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