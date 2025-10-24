package dev.bilal.games;

// Middleman between controller and repository.
// It organizes how your app processes data before sending it to the frontend.

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    // "@AutoWired". It will let the framework know that I want the framework to instantiate this class here for us.
    @Autowired
    private GameRepository gameRepository;

    public List<Game> allGames() {
        return gameRepository.findAll();
    }
    public Optional <Game> oneGame(ObjectId id) {
        return gameRepository.findById(id);
    }
    public Optional <Game> oneGameByGameId(int gameId) {
        return gameRepository.findByGameId(gameId);
    }
}
