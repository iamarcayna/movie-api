package com.rnacode.movieapi.Services;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.rnacode.movieapi.Models.Movie;
import com.rnacode.movieapi.Models.Review;
import com.rnacode.movieapi.Repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    public ReviewService(ReviewRepository revieRepository, MongoTemplate mongoTemplate) {
        this.reviewRepository = revieRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Review createReview(String imdbId, String reviewBody) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Update the database data.
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)).first();
        return review;
    }
}
