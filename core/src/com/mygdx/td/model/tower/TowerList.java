package com.mygdx.td.model.tower;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TowerList {

    private final List<Tower> towers;
    // добавить id башен

    public TowerList() {
        towers = new ArrayList<>();
        towers.add(new Tower("BASE", 100, 0, "", 0,
                Tower.ActionType.DoNothing, 0, 0, null, new ArrayList<TowerUpgrade>()));
    }

    public void addTower(Tower tower) {
        towers.add(tower);
    }

}
