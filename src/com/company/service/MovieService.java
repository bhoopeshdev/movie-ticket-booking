package com.company.service;

import com.company.database.MovieDB;
import com.company.entity.Movie;
import com.company.enums.MovieGenre;

public class MovieService {

    private final MovieDB movieDB = MovieDB.getInstance();

    public Movie createMovie(String movieName, MovieGenre genre) {
        long movieId = Math.round(Math.random() * Long.MAX_VALUE);
        Movie movie = new Movie(movieId,movieName,genre);
        return movieDB.saveMovie(movie);
    }

    public Movie getMovie(Long movieId) {
        return movieDB.getMovie(movieId);
    }
}
