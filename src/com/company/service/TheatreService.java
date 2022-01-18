package com.company.service;

import com.company.database.ScreenDB;
import com.company.database.TheatreDB;
import com.company.entity.Screen;
import com.company.entity.Theatre;

public class TheatreService {

  private final TheatreDB theatreDB = TheatreDB.getInstance();
  private final ScreenDB screenDB = ScreenDB.getInstance();


  public Theatre createTheatre(String theatreName, String city, String locality) {
    long theatreId = Math.round(Math.random() * Long.MAX_VALUE);
    Theatre theatre = new Theatre(theatreId, theatreName, city, locality);
    return theatreDB.saveTheatre(theatre);
  }

  public Theatre getTheatre(long theatreId) {
    return theatreDB.getTheatre(theatreId);
  }

  public Screen createScreen(Long theatreId, int seatCount) {
    long screenId = Math.round(Math.random() * Long.MAX_VALUE);
    Screen screen = new Screen(screenId, theatreId, seatCount);
    return screenDB.saveScreen(screen);
  }

    public int getScreenSeatCount(Long screenId) {
      Screen screen = screenDB.getScreen(screenId);
      if(screen != null) {
        return screen.getMaxSeats();
      }
      return 0;
    }
}
