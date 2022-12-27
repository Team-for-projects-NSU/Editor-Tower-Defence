package com.mygdx.td.model;

import com.mygdx.td.model.level.LevelMap;
import com.mygdx.td.model.level.LevelMapList;

public class MapsCorrectnessChecker {

    public static boolean checkCorrectness(LevelMapList maps) {
        boolean mapsCorr = true;
        for (LevelMap map : maps.getMaps()) {
            mapsCorr &= map.normalizeMap();
        }
        return mapsCorr;
    }
}
