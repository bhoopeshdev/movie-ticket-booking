package com.company.entity;

public class Screen {

    private Long screenId;
    private Long theatreId;
    private int maxSeats;

    public Screen(Long screenId, Long theatreId, int maxSeats) {
        this.screenId = screenId;
        this.theatreId = theatreId;
        this.maxSeats = maxSeats;
    }

    public Long getScreenId() {
        return screenId;
    }
    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }
}
