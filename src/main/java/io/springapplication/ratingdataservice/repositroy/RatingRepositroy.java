package io.springapplication.ratingdataservice.repositroy;

import io.springapplication.ratingdataservice.models.Rating;
import io.springapplication.ratingdataservice.models.UserRating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.attribute.UserPrincipal;

@Repository
public interface RatingRepositroy extends MongoRepository<Rating,String> {



}
