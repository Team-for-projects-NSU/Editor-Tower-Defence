package com.mygdx.td.model.level;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Wave {

    private int waveDelay;
    private int enemyAmount;
    private int enemyFrequency;
    private List<Integer> enemyTypeIDs;

    public Wave(int waveDelay, int enemyAmount, int enemyFrequency) {
        enemyTypeIDs = new ArrayList<>();
        this.waveDelay = waveDelay;
        this.enemyAmount = enemyAmount;
        this.enemyFrequency = enemyFrequency;
    }

    public void addEnemyType(int enemyTypeID) {
        enemyTypeIDs.add(enemyTypeID);
    }

    public void removeEnemyType(int typeIndex) {
        enemyTypeIDs.remove(typeIndex);
    }

}
