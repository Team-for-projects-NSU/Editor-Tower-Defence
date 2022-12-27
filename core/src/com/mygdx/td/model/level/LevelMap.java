package com.mygdx.td.model.level;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Setter
@Getter
public class LevelMap {

    public enum Tile {
        EMPTY,
        PATH,
        BUILDING,
        SPAWNER,
        BASE
    }

    private final int width;
    private final int height;

    private Integer[] baseCoordinates;
    private Integer[] spawnerCoordinates;

    private Tile[][] field;

//    private final Integer[] spawnerCoordinates;
//    private final Integer[] baseCoordinates;

    public LevelMap(int mapWidth, int mapHeight) {
        width = mapWidth;
        height = mapHeight;
        field = new Tile[mapWidth][mapHeight];
        for (Tile[] raw : field) {
            Arrays.fill(raw, Tile.EMPTY);
        }

        baseCoordinates = new Integer[2];
        spawnerCoordinates = new Integer[2];
    }

    public void changeMapTileType(int x, int y, Tile newType) {
        field[x][y] = newType;
        if (newType == Tile.BASE) {
            if (baseCoordinates[0] != null) {
                field[baseCoordinates[0]][baseCoordinates[1]] = Tile.EMPTY;
            }
            baseCoordinates[0] = x;
            baseCoordinates[1] = y;
        } else if (newType == Tile.SPAWNER) {

            if (spawnerCoordinates[0] != null) {
                field[spawnerCoordinates[0]][spawnerCoordinates[1]] = Tile.EMPTY;
            }
            spawnerCoordinates[0] = x;
            spawnerCoordinates[1] = y;
        }
    }
}
