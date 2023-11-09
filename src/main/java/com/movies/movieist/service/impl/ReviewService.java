package com.movies.movieist.service.impl;

import com.movies.movieist.model.Review;

public interface ReviewService {

    Review createReview(String reviewBody, String imdbId);
}
