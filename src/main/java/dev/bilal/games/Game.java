package dev.bilal.games;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Game {


    @Id
    @JsonSerialize(using = ToStringSerializer.class)

    private ObjectId id;


    private int gameId;

    private String title;

    private List<String> genre;

    private List<String> platform;

    private int release_year;

    private double rating;

    private String poster;

    private String trailer;

    //"Manual Reference Relationship". This will allow the db only ids of the reviews in a separate collection.
    @DocumentReference
    private List<Review> reviewIds;




}
