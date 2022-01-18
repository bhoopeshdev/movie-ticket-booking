package com.company.service;

import com.company.database.BookingDB;
import com.company.entity.Booking;
import com.company.entity.Payment;
import com.company.entity.Seat;
import com.company.enums.BookingStatus;
import com.company.enums.PaymentStatus;
import com.company.providers.SeatLockProvider;

import java.util.List;

public class BookingService {

  private final BookingDB bookingDB = BookingDB.getInstance();
  private final ShowService showService = new ShowService();
  private final SeatLockProvider seatLockProvider = SeatLockProvider.getInstance();

  public Booking initiateBooking(Long showId, List<Long> seatIds, Long userId) {
    if (showService.getShow(showId) == null) {
      System.out.println("show not available");
      return null;
    }
    List<Seat> seatList = showService.getSeats(seatIds);
    if (!showService.isSeatsAvailable(seatIds) && !seatLockProvider.isSeatsUnLocked(seatList)) {
      System.out.println("Seats not available");
      return null;
    }

    // lock seats for booking
    if(!seatLockProvider.lockSeats(seatList, userId)) {
        return null;
    }

    Long bookingId = Math.round(Math.random() * Long.MAX_VALUE);
    Booking booking = new Booking(bookingId,showId,userId,seatIds, BookingStatus.PENDING);
    return bookingDB.saveBooking(booking);
  }

  public Booking completeBooking(Long bookingId, Payment payment) {

    Booking booking = bookingDB.getBooking(bookingId);
    if (booking == null) {
      System.out.println("Booking not available");
      return null;
    }

    if (payment.getPaymentStatus().equals(PaymentStatus.COMPLETED)) {
      booking.setBookingStatus(BookingStatus.CONFIRMED);
    } else if (payment.getPaymentStatus().equals(PaymentStatus.FAIL)) {
      booking.setBookingStatus(BookingStatus.CANCEL);
    }

    List<Seat> seatList = showService.getSeats(booking.getSeatIds());
    if(!seatLockProvider.unlockSeats(seatList, booking.getUserId())) {
      System.out.println("cannot unlock seats");
      return null;
    }
    return bookingDB.saveBooking(booking);
  }
}
