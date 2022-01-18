package com.company.service;

import com.company.database.SeatDB;
import com.company.database.ShowDB;
import com.company.entity.Seat;
import com.company.entity.Show;
import com.company.enums.SeatStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowService {

  private final TheatreService theatreService;
  private final ShowDB showDB = ShowDB.getInstance();
  private final SeatDB seatDB = SeatDB.getInstance();

  public ShowService() {
    theatreService = new TheatreService();
  }

  public Show createShow(
      Long movieId, Long theatreId, Long screenId, LocalDateTime startTime, LocalDateTime endTime) {
    Long showId = Math.round(Math.random() * Long.MAX_VALUE);
    long seatCount = theatreService.getScreenSeatCount(screenId);
    for(int i = 1;i <= seatCount;i++) {
      long seatId = Math.round(Math.random() * Long.MAX_VALUE);
      Seat seat = new Seat(seatId,i,SeatStatus.AVAILABLE,showId);
      Seat savedSeat = seatDB.saveSeat(seat);
    }
    Show show = new Show(showId, theatreId, screenId, movieId, seatCount, startTime, endTime);
    return showDB.saveShow(show);
  }

  public Show getShow(Long showId) {
    return showDB.getShow(showId);
  }

  public List<Seat> getAvailableSeats(Long showId) {
    return seatDB.getSeatForShowIdAndStatus(showId, SeatStatus.AVAILABLE);
  }

  public boolean isSeatsAvailable(List<Long> seatIds) {
    for (Long seatId : seatIds) {
      Seat curSeat = seatDB.getSeat(seatId);
      if(curSeat == null || !curSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)) {
          return false;
      }
    }
    return true;
  }

  public List<Seat> getSeats(List<Long> seatIdList) {
    List<Seat> seatList = new ArrayList<>();
    for (Long seatId : seatIdList) {
        Seat seat = seatDB.getSeat(seatId);
        if(seat != null) {
          seatList.add(seat);
        }
    }
    return seatList;
  }
}
