package com.movies.movieist.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;

}
