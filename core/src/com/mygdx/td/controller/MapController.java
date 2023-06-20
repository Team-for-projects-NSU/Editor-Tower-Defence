package com.mygdx.td.controller;

import com.mygdx.td.model.level.Coordinates;
import com.mygdx.td.model.level.LevelMap;
import com.mygdx.td.model.level.LevelMapList;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class MapController {

    @Getter
    private final LevelMapList maps;
    private final Map<Color, LevelMap.Tile> tileColors;

    public MapController() {
        maps = new LevelMapList();
        tileColors = new HashMap<>();
        tileColors.put(Color.GREEN, LevelMap.Tile.Background);
        tileColors.put(Color.YELLOW, LevelMap.Tile.Road);
        tileColors.put(Color.GRAY, LevelMap.Tile.Plot);
        tileColors.put(Color.RED, LevelMap.Tile.Plot);
        tileColors.put(Color.BLUE, LevelMap.Tile.Plot);
    }

    public void addMap(int width, int height) {
        maps.addMap(new LevelMap(width, height));
    }

    public void changeTile(int x, int y, Color color) {
        maps.getMap(0).changeMapTileType(x, y, tileColors.get(color));
        if (color.equals(Color.RED)) {
            maps.getMap(0).setSpawnerCoordinates(new Coordinates(x, y));
        }

        if (color.equals(Color.BLUE)) {
            maps.getMap(0).setBaseCoordinates(new Coordinates(x, y));
        }
    }

}
