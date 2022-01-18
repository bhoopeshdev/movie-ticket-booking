package com.company.entity;

import com.company.enums.BookingStatus;

import java.util.List;

public class Booking {

    private Long bookingId;
    private Long showId;
    private Long userId;
    private List<Long> seatIds;
    private BookingStatus bookingStatus;

    public Booking(Long bookingId, Long showId, Long userId, List<Long> seatIds, BookingStatus bookingStatus) {
        this.bookingId = bookingId;
        this.showId = showId;
        this.userId = userId;
        this.seatIds = seatIds;
        this.bookingStatus = bookingStatus;
    }

    public Booking(Booking booking) {
        this.bookingId = booking.bookingId;
        this.showId = booking.showId;
        this.userId = booking.userId;
        this.seatIds = booking.seatIds;
        this.bookingStatus = booking.bookingStatus;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Long> seatIds) {
        this.seatIds = seatIds;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
