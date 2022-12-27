package com.mygdx.td.logic.level;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Level {

    private int defaultWaveInterval;
    private List<Wave> waves;
    private int startCurrency;
    private int reward;
    private HashMap<String, Float> enemyModifiers;
    private int mapID;

    public Level(int mapID) {
        waves = new ArrayList<>();
        this.mapID = mapID;
    }

    public void addWave(Wave wave) {
        waves.add(wave);
    }
}
