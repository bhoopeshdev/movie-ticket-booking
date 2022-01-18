package com.company.database;

import com.company.entity.Screen;

import java.util.HashMap;

public class ScreenDB {

    private static volatile ScreenDB screenDB;
    private final HashMap<Long, Screen> screenMap;

    private ScreenDB() {
        screenMap = new HashMap<>();
    }

    public static ScreenDB getInstance() {
        if(screenDB == null) {
            synchronized (PaymentDB.class) {
                if(screenDB == null) {
                    screenDB = new ScreenDB();
                }
            }
        }
        return screenDB;
    }

    public Screen saveScreen(Screen screen) {
        screenMap.put(screen.getScreenId(),screen);
        return screen;
    }

    public Screen getScreen(Long screenId) {
        if(screenMap.containsKey(screenId)) {
            return screenMap.get(screenId);
        }
        return null;
    }
}
