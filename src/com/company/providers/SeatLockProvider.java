package com.company.providers;

import com.company.entity.Seat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatLockProvider {

    private static volatile SeatLockProvider seatLockProvider;
    Map<Seat,Long> seatLockMap;

    private SeatLockProvider() {
        this.seatLockMap = new HashMap<>();
    }

    public static SeatLockProvider getInstance() {
        if(seatLockProvider == null) {
            synchronized (SeatLockProvider.class) {
                if(seatLockProvider == null) {
                    seatLockProvider = new SeatLockProvider();
                }
            }
        }
        return seatLockProvider;
    }
    
    public boolean lockSeats(List<Seat> seatList, Long userId) {
        for (Seat seat : seatList) {
            if(seatLockMap.containsKey(seat)) {
                System.out.println("cannot lock seat");
                return false;
            }    
            else {
                seatLockMap.put(seat,userId);
                System.out.println("seat lock : " + seat.getSeatNumber());
            }
        }
        return true;
    }
    
    public boolean unlockSeats(List<Seat> seatList, Long userId) {
        for (Seat seat : seatList) {
            if(seatLockMap.containsKey(seat)){
                if(!seatLockMap.get(seat).equals(userId)) {
                    System.out.println("cannot release lock by user");
                    return false;
                }
                seatLockMap.remove(seat);
            }
        }
        return true;
    }
    
    public boolean isSeatsUnLocked(List<Seat> seatList) {
        for (Seat seat : seatList) {
            if(seatLockMap.containsKey(seat)) {
                return false;
            }
        }
        return true;
    }
}
