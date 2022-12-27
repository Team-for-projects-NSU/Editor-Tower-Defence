package com.mygdx.td.logic.enemy;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EnemyList {

    private final List<Enemy> enemies;

    public EnemyList() {
        enemies = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
