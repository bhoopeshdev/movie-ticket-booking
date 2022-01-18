package com.company.entity;

import java.sql.Time;
import java.time.LocalDateTime;

public class Show {
    private Long showId;
    private Long theatreId;
    private Long screenId;
    private Long movieId;
    private Long seatCount;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    public Show(Long showId, Long theatreId, Long screenId, Long movieId, Long seatCount, LocalDateTime startTime, LocalDateTime endTime) {
        this.showId = showId;
        this.theatreId = theatreId;
        this.screenId = screenId;
        this.movieId = movieId;
        this.seatCount = seatCount;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Long seatCount) {
        this.seatCount = seatCount;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
