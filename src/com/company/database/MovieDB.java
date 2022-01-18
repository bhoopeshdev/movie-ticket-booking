package com.company.database;

import com.company.entity.Movie;

import java.util.HashMap;

public class MovieDB {

    private static volatile MovieDB movieDB;
    private final HashMap<Long, Movie> movieMap;

    private MovieDB() {
        movieMap = new HashMap<>(0);
    }

    public static MovieDB getInstance() {
        if(movieDB == null) {
            synchronized (MovieDB.class) {
                if(movieDB == null) {
                    movieDB = new MovieDB();
                }
            }
        }
        return movieDB;
    }

    public Movie saveMovie(Movie movie) {
        movieMap.put(movie.getMovieId(),movie);
        return movie;
    }

    public Movie getMovie(Long movieId) {
        if(movieMap.containsKey(movieId)) {
            return movieMap.get(movieId);
        }
        return null;
    }
}
