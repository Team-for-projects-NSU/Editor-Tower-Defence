package com.mygdx.td.logic;

import com.mygdx.td.logic.level.LevelMap;
import com.mygdx.td.logic.level.LevelMapList;

public class MapsCorrectnessChecker {

    private static boolean hasTileType(LevelMap map, LevelMap.Tile tileType) {
        boolean hasTile = false;

        if (map.getBaseCoordinates()[0] == null || map.getSpawnerCoordinates()[0] == null) {
            return false;
        }

        LevelMap.Tile[][] field = map.getField();

        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                if (field[i][j] == tileType) {
                    if (hasTile) {
                        System.out.println("Level needs only one base!");
                        return false;
                    }
                    hasTile = true;
                }
            }
        }
        return hasTile;
    }

    private static boolean checkMap(LevelMap map) {
        return hasTileType(map, LevelMap.Tile.BASE) &
                hasTileType(map, LevelMap.Tile.SPAWNER);
    }

    public static boolean checkCorrectness(LevelMapList maps) {
        boolean mapsCorr = true;
        for (LevelMap map : maps.getMaps()) {
            mapsCorr &= checkMap(map);
        }
        return mapsCorr;
    }
}
