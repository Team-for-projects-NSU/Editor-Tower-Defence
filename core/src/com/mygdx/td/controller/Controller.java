package com.mygdx.td.controller;

import com.mygdx.td.model.MapsCorrectnessChecker;
import com.mygdx.td.model.Serializer;
import com.mygdx.td.model.enemy.EnemyList;
import com.mygdx.td.model.tower.TowerList;
import lombok.Getter;

@Getter
public class Controller {

    private final MapController mapController;
    private final LevelController levelController;

    public Controller() {
        mapController = new MapController();
        levelController = new LevelController();
    }

    public void generateFiles() {
        MapsCorrectnessChecker.checkCorrectness(mapController.getMaps());
        // other correctness checkers (if needed)

        TowerList towerList = new TowerList();
        EnemyList enemyList = new EnemyList();

        Serializer serializer = new Serializer("config_files/");
        serializer.serializeAll(towerList, enemyList, levelController.getLevels(), mapController.getMaps());
    }
}
