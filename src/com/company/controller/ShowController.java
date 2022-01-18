package com.company.controller;

import com.company.entity.Seat;
import com.company.entity.Show;
import com.company.service.ShowService;

import java.time.LocalDateTime;
import java.util.List;

public class ShowController {

  private final ShowService showService;

    public ShowController() {
        showService = new ShowService();
    }

    public Show createShow(
      long movieId,
      long theatreId,
      long screenId,
      LocalDateTime startTime,
      LocalDateTime endTime) {
      return showService.createShow(movieId,theatreId,screenId,startTime,endTime);
  }

  public Show getShow(long showId) {
      return showService.getShow(showId);
  }

  public List<Seat> getAvailableSeats(long showId) {
        return showService.getAvailableSeats(showId);
  }

 }
