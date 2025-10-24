package dev.bilal.games;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    // get all
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return new ResponseEntity<>(gameService.allGames(), HttpStatus.OK);
    }

    // get by Mongo ObjectId
    @GetMapping("/byObjectId/{id}")
    public ResponseEntity<Optional<Game>> getOneGame(@PathVariable ObjectId id) {
        return new ResponseEntity<>(gameService.oneGame(id), HttpStatus.OK);
    }

    // get by numeric gameId
    @GetMapping("/{gameId}")
    public ResponseEntity<Optional<Game>> getOneGameByGameId(@PathVariable int gameId) {
        return new ResponseEntity<>(gameService.oneGameByGameId(gameId), HttpStatus.OK);
    }
}
