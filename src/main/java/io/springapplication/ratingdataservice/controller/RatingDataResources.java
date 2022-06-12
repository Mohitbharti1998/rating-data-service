package io.springapplication.ratingdataservice.controller;


import io.springapplication.ratingdataservice.models.Rating;
import io.springapplication.ratingdataservice.models.Response;
import io.springapplication.ratingdataservice.repositroy.RatingRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ratingsData")
public class RatingDataResources {

    @Autowired
    public RatingRepositroy ratingRepositroy;

    @Autowired
    public Response response;

    @GetMapping("/count")
    public Object getAllRating() {
        return Collections.singletonMap("count",ratingRepositroy.findAll().size());
    }

    @GetMapping("/fetchAll")
    public Object getAll() {
        List<Rating> ratings = ratingRepositroy.findAll();
        if(ratings.isEmpty()) {
            response.setStatus("No record found");
            response.setData(ratings);
            return response;
        }
        response.setStatus("success");
        response.setError(null);
        response.setData(ratings);
        return response;
    }

    @RequestMapping("/ratingById")
    public Object getRating(@RequestParam String movieId) {
        Optional<Rating> rating = ratingRepositroy.findById(movieId);
        if (rating.isPresent()) {
            response.setStatus("success");
            response.setError(null);
            response.setData(rating);
            return response;
        }
        response.setStatus("failure");
        response.setError("No record found");
        response.setData(rating);
        return response;
    }


    @RequestMapping("/insertRating")
    public Object insertUserRating(@RequestBody Rating insert) {
        Rating rating;
        try {
            rating = ratingRepositroy.insert(insert);
            response.setStatus("success");
            response.setError(null);
            response.setData(rating);
            return response;
        } catch (org.springframework.dao.DuplicateKeyException error) {
            response.setStatus("failure");
            response.setError("Already data present with this Id");
            response.setData(insert);
            return response;
            }

    }

    @RequestMapping("/updateRating")
    public Object updateUserRating(@RequestBody Rating update) {
        Optional<Rating> rating = ratingRepositroy.findById(update.getMovieId());

        if(rating.isPresent()){
            ratingRepositroy.save(update);
            response.setStatus("success");
            response.setError(null);
            response.setData(rating);
            return response;
        }
        response.setStatus("failure");
        response.setError("No record found");
        response.setData(update);
        return response;

    }

    @RequestMapping("/delete")
    public Object deleteRating(@RequestParam String movieId) {
        Optional<Rating> rating = ratingRepositroy.findById(movieId);
        if (rating.isPresent()) {
            ratingRepositroy.deleteById(movieId);
            response.setStatus("success");
            response.setError(null);
            response.setData(rating);
            return response;
        }
        response.setStatus("failure");
        response.setError("No record found");
        response.setData(rating);
        return response;
    }





}