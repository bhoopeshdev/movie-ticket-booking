package com.company.database;

import com.company.entity.Show;

import java.util.HashMap;

public class ShowDB {

    private static volatile ShowDB showDB;
    private final HashMap<Long, Show> showMap;

    private ShowDB() {
        showMap = new HashMap<>();
    }

    public static ShowDB getInstance() {
        if(showDB == null) {
            synchronized (ShowDB.class) {
                if(showDB == null) {
                    showDB = new ShowDB();
                }
            }
        }
        return showDB;
    }

    public Show saveShow(Show show) {
        showMap.put(show.getShowId(),show);
        return show;
    }

    public Show getShow(Long showId) {
        if(showMap.containsKey(showId)) {
            return showMap.get(showId);
        }
        return null;
    }
}
