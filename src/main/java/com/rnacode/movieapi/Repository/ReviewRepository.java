package com.rnacode.movieapi.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rnacode.movieapi.Models.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
