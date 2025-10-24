package dev.bilal.games;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
public class Review {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String body;

    public Review(ObjectId id, String body) {
        this.id = id;
        this.body = body;
    }

    public Review() {}
}
