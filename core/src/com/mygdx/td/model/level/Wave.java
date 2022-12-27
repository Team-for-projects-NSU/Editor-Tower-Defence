package com.mygdx.td.model.level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wave {

    private int waveDelay;
    private int enemyCount;
    private int enemyInterval;
    private List<Integer> enemyTypeIDs;

    public Wave(int waveDelay, int enemyAmount, int enemyFrequency) {
        enemyTypeIDs = new ArrayList<>();
        this.waveDelay = waveDelay;
        this.enemyCount = enemyAmount;
        this.enemyInterval = enemyFrequency;
    }

    public void addEnemyType(int enemyTypeID) {
        enemyTypeIDs.add(enemyTypeID);
    }

    public void removeEnemyType(int typeIndex) {
        enemyTypeIDs.remove(typeIndex);
    }

}
