package com.company.controller;

import com.company.entity.Booking;
import com.company.entity.Payment;
import com.company.service.BookingService;

import java.util.List;

public class BookingController {

    private final BookingService bookingService = new BookingService();

    public Booking initiateBooking(Long showId, List<Long> seatIds, Long userId) {
        return bookingService.initiateBooking(showId,seatIds,userId);
    }

    public Booking completeBooking(Long bookingId, Payment payment) {
        return bookingService.completeBooking(bookingId,payment);
    }
}
