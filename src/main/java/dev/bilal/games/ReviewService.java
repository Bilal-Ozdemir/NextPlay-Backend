package dev.bilal.games;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // A template can be used to talk to the database. Especially if it's a complex thing that can't be implemented in a repository.
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String body, int gameId) {
        Review review =  reviewRepository.insert(new Review( null,body));


        mongoTemplate.update(Game.class)
                .matching(Criteria.where("gameId").is(gameId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;

    }
}
