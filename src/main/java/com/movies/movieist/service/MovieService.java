package com.movies.movieist.service;

import com.movies.movieist.model.Movies;
import com.movies.movieist.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MovieService {
    Optional<Movies> singleMovies(String imdbId);
    List<Movies> listOfAllMovies();
}
