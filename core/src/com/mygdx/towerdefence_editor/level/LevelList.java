package com.mygdx.towerdefence_editor.level;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LevelList {

    private List<Level> levels;

    public LevelList() {
        levels = new ArrayList<>();
    }

    public void addLevel(Level level) {
        levels.add(level);
    }
}
