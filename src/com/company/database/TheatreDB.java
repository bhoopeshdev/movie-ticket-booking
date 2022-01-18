package com.company.database;

import com.company.entity.Theatre;

import java.util.HashMap;

public class TheatreDB {

    private static volatile TheatreDB theatreDB;
    private final HashMap<Long, Theatre> theatreMap;

    private TheatreDB() {
        theatreMap = new HashMap<>();
    }

    public static TheatreDB getInstance() {
        if(theatreDB == null) {
            synchronized (TheatreDB.class) {
                if(theatreDB == null) {
                    theatreDB = new TheatreDB();
                }
            }
        }
        return theatreDB;
    }

    public Theatre saveTheatre(Theatre theatre) {
        theatreMap.put(theatre.getTheatreId(),theatre);
        return theatre;
    }

    public Theatre getTheatre(Long theatreId) {
        if(theatreMap.containsKey(theatreId)) {
            return theatreMap.get(theatreId);
        }
        return null;
    }
}
