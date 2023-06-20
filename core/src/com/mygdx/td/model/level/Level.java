package com.mygdx.td.model.level;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Level {

    private int id;
    private int startingCurrency;
    private int reward;
    private String backgroundTextureName;
    private String plotTextureName;
    private String roadTextureName;
    private List<Wave> waves;
    private int mapID;

    public Level() {
        waves = new ArrayList<>();
    }

    public void addWave(Wave wave) {
        waves.add(wave);
    }
}
