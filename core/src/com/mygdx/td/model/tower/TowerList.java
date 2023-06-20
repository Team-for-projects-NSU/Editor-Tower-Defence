package com.mygdx.td.model.tower;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TowerList {

    private final List<Tower> towers;

    public TowerList() {
        towers = new ArrayList<>();
    }

    public void addTower(Tower tower) {
        towers.add(tower);
    }

}
