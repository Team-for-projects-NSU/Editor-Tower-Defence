package com.mygdx.td.logic.level;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LevelMapList {

    private List<LevelMap> maps;

    public LevelMapList() {
        maps = new ArrayList<>();
    }

    public void addMap(LevelMap levelMap) {
        maps.add(levelMap);
    }
}
