package dev.bilal.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        // Converting it to a string form int.
        int gameId = Integer.parseInt(payload.get("gameId"));
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("body"), gameId), HttpStatus.CREATED);
    }

}
