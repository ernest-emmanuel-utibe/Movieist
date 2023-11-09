package com.movies.movieist.service.impl;

import com.movies.movieist.model.Movies;
import com.movies.movieist.repository.MovieRepository;
import com.movies.movieist.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    public List<Movies> listOfAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movies> singleMovies(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
