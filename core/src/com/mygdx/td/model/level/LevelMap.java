package com.mygdx.td.model.level;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Setter
@Getter
@ToString
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

    private Vector2 baseCoordinates;
    private Vector2 spawnerCoordinates;

    private Tile[][] field;

    public LevelMap(int mapWidth, int mapHeight) {
        width = mapWidth;
        height = mapHeight;
        field = new Tile[mapWidth][mapHeight];
        for (Tile[] raw : field) {
            Arrays.fill(raw, Tile.EMPTY);
        }
        baseCoordinates = new Vector2();
        spawnerCoordinates = new Vector2();
    }

    public void changeMapTileType(int x, int y, Tile newType) {
        field[x][y] = newType;
        /*
        if (newType == Tile.BASE) {
            field[x][y] = Tile.Plot;
            if (baseCoordinates.x != -1) {
                field[(int) baseCoordinates.x][(int) baseCoordinates.y] = Tile.Plot;
            }
            baseCoordinates.x = x;
            baseCoordinates.y = y;
        } else if (newType == Tile.SPAWNER) {
            field[x][y] = Tile.Plot;
            if (spawnerCoordinates.x != -1) {
                field[(int) spawnerCoordinates.x][(int) spawnerCoordinates.y] = Tile.Plot;
            }
            spawnerCoordinates.x = x;
            spawnerCoordinates.y = y;
        }
         */
    }

    private boolean findBase() {
        boolean hasTile = false;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (field[i][j] == Tile.BASE) {
                    if (hasTile) {
                        return false;
                    }
                    hasTile = true;
                    field[i][j] = Tile.BUILDING;
                    baseCoordinates.x = i;
                    baseCoordinates.y = j;
                }
            }
        }
        return hasTile;
    }

    private boolean findSpawner() {
        boolean hasTile = false;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (field[i][j] == Tile.SPAWNER) {
                    if (hasTile) {
                        return false;
                    }
                    hasTile = true;
                    field[i][j] = Tile.BUILDING;
                    spawnerCoordinates.x = i;
                    spawnerCoordinates.y = j;
                }
            }
        }

        return hasTile;
    }

    public boolean normalizeMap() {
        return findBase() & findSpawner();
    }

    public TileType[][] convert() {
        TileType[][] tileMap = new TileType[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tileMap[i][j] = TileType.Background;
                if (field[i][j] == Tile.BUILDING) {
                    tileMap[i][j] = TileType.Plot;
                } else if (field[i][j] == Tile.PATH) {
                    tileMap[i][j] = TileType.Road;
                }
            }
        }

        return tileMap;
    }
}
