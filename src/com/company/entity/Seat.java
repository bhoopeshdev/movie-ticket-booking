package com.company.entity;

import com.company.enums.SeatStatus;

public class Seat {
    private Long seatId;
    private int seatNumber;
    private SeatStatus seatStatus;
    private Long showId;

    public Seat(Long seatId, int seatNumber, SeatStatus seatStatus, Long showId) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
        this.showId = showId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
