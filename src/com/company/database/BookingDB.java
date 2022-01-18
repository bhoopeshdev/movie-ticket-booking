package com.company.database;

import com.company.entity.Booking;

import java.util.HashMap;

public class BookingDB {

    private static volatile BookingDB bookingDB;
    private final HashMap<Long, Booking> bookingMap;
    
    private BookingDB() {
        bookingMap = new HashMap<>();
    }

    public static BookingDB getInstance() {
        if(bookingDB == null) {
            synchronized (BookingDB.class) {
                if(bookingDB == null) {
                    bookingDB = new BookingDB();
                }
            }
        }
        return bookingDB;
    }
    
    public Booking saveBooking(Booking booking) {
        bookingMap.put(booking.getBookingId(),new Booking(booking));
        return booking;
    }

    public Booking getBooking(Long bookingId) {
        if(bookingMap.containsKey(bookingId)) {
            return bookingMap.get(bookingId);
        }
        return null;
    }
}
