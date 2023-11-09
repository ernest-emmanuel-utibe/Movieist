package com.movies.movieist.controller;

import com.movies.movieist.model.Movies;
import com.movies.movieist.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        return new ResponseEntity<>(movieService.listOfAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}/")
    public ResponseEntity<Optional<Movies>> getSingleMovie(@PathVariable("imdbId") String imdbId) {
        return new ResponseEntity<>(movieService.singleMovies(imdbId), HttpStatus.OK);

    }
}
