package com.mygdx.td.controller;

import com.mygdx.td.model.level.Level;
import com.mygdx.td.model.level.LevelList;
import lombok.Getter;
public class LevelController {

    @Getter
    private final LevelList levels;

    public LevelController() {
        levels = new LevelList();
    }

    public void addLevel(int startCurrency, int reward, int mapID) {
        Level newLevel = new Level();
        newLevel.setStartingCurrency(startCurrency);
        newLevel.setReward(reward);
        newLevel.setMapID(mapID);

        levels.addLevel(newLevel);
    }

}
