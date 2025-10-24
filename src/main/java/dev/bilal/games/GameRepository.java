package dev.bilal.games;

// Responsible for reading and writing data in MongoDB.
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends MongoRepository<Game, ObjectId> {
    Optional<Game> findByGameId(int gameId);
}

