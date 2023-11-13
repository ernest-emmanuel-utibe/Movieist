package com.movies.movieist.service;

import com.movies.movieist.model.Review;

public interface ReviewService {

    Review createReview(String reviewBody, String imdbId);
}
