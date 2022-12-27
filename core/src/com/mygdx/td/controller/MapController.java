package com.mygdx.td.controller;

import com.mygdx.td.model.level.LevelMap;
import com.mygdx.td.model.level.LevelMapList;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class MapController {

    @Getter
    private final LevelMapList maps;
    private Map<Color, LevelMap.Tile> tileColors;

    public MapController() {
        maps = new LevelMapList();
        tileColors = new HashMap<>();
        tileColors.put(Color.GREEN, LevelMap.Tile.EMPTY);
        tileColors.put(Color.YELLOW, LevelMap.Tile.PATH);
        tileColors.put(Color.GRAY, LevelMap.Tile.BUILDING);
        tileColors.put(Color.RED, LevelMap.Tile.SPAWNER);
        tileColors.put(Color.BLUE, LevelMap.Tile.BASE);
    }

    public void addMap(int width, int height) {
        maps.addMap(new LevelMap(width, height));
    }

    public void changeTile(int x, int y, Color color) {
        maps.getMap(0).changeMapTileType(x, y, tileColors.get(color));
    }

}
