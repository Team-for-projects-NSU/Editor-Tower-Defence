package com.mygdx.td.model.level;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
public class LevelMap {

    public enum Tile {
        Background,
        Road,
        Plot
    }

    private int id;

    private final int width;
    private final int height;

    private Coordinates baseCoordinates;
    private Coordinates spawnerCoordinates;

    private Tile[][] field;

    public LevelMap(int mapWidth, int mapHeight) {
        width = mapWidth;
        height = mapHeight;
        field = new Tile[mapWidth][mapHeight];
        for (Tile[] raw : field) {
            Arrays.fill(raw, Tile.Background);
        }
        baseCoordinates = new Coordinates();
        spawnerCoordinates = new Coordinates();
    }

    public void changeMapTileType(int x, int y, Tile newType) {
        field[x][y] = newType;
    }

    public void changeMapTileType(Coordinates coordinates, Tile newType) {
        field[(int) coordinates.x][(int) coordinates.y] = newType;
    }

    public Tile getTileType(int x, int y) {
        return field[x][y];
    }

    public Tile getTileType(Coordinates coordinates) {
        return field[(int) coordinates.x][(int) coordinates.y];
    }

    public TileType[][] convert() {
        TileType[][] tileMap = new TileType[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tileMap[i][j] = TileType.Background;
                if (field[i][j] == Tile.Plot) {
                    tileMap[i][j] = TileType.Plot;
                } else if (field[i][j] == Tile.Road) {
                    tileMap[i][j] = TileType.Road;
                }
            }
        }

        return tileMap;
    }

    public void setBaseCoordinates(Coordinates baseCoordinates) {
        this.baseCoordinates = baseCoordinates;
    }

    public void setSpawnerCoordinates(Coordinates spawnerCoordinates) {
        this.spawnerCoordinates = spawnerCoordinates;
    }

    public void setField(Tile[][] field) {
        this.field = field;
    }
}
