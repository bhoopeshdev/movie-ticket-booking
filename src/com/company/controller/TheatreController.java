package com.company.controller;

import com.company.entity.Screen;
import com.company.entity.Theatre;
import com.company.service.TheatreService;

public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController() {
        theatreService = new TheatreService();
    }

    public Theatre createTheatre(String theatreName,String city, String locality) {
        return theatreService.createTheatre(theatreName,city,locality);
    }

    public Theatre getTheatre(long theatreId) {
        return theatreService.getTheatre(theatreId);
    }

    public Screen addScreen(long theatreId,int seatCount) {
        return theatreService.createScreen(theatreId,seatCount);
    }
}
