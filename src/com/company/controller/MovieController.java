package com.company.controller;

import com.company.entity.Movie;
import com.company.enums.MovieGenre;
import com.company.service.MovieService;

public class MovieController {

    private final MovieService movieService;

    public MovieController() {
        movieService = new MovieService();
    }

    public Movie createMovie(String movieName, MovieGenre genre) {
        return movieService.createMovie(movieName,genre);
    }

    public Movie getMovie(Long movieId) {
        return movieService.getMovie(movieId);
    }
}
