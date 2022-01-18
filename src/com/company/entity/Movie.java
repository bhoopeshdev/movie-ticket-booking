package com.company.entity;

import com.company.enums.MovieGenre;

public class Movie {

    private Long movieId;
    private String movieName;
    private MovieGenre genre;


    public Movie(Long movieId, String movieName, MovieGenre genre) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }
}
