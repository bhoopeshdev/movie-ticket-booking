package com.company.database;

import com.company.entity.Seat;
import com.company.enums.SeatStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeatDB {

    private static volatile SeatDB seatDB;
    private final HashMap<Long, Seat> seatMap;

    private SeatDB() {
        seatMap = new HashMap<>();
    }

    public static SeatDB getInstance() {
        if(seatDB == null) {
            synchronized (SeatDB.class) {
                if(seatDB == null) {
                    seatDB = new SeatDB();
                }
            }
        }
        return seatDB;
    }

    public Seat saveSeat(Seat seat) {
        seatMap.put(seat.getSeatId(),seat);
        return seat;
    }

    public Seat getSeat(Long seatId) {
        if(seatMap.containsKey(seatId)) {
            return seatMap.get(seatId);
        }
        return null;
    }

  public List<Seat> getSeatForShowIdAndStatus(Long showId, SeatStatus seatStatus) {
    return seatMap.values().stream()
        .filter(s -> s.getSeatStatus().equals(seatStatus) && s.getShowId().equals(showId))
        .collect(Collectors.toList());
  }
}
