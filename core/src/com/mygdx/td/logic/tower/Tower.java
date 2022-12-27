package com.mygdx.td.logic.tower;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Tower {

    public enum ActionType {
        Default,
        DoNothing,
        BasicAttack,
        GenerateCurrency
    }

    public enum ActionParameter {

    }

    private String name;
    private int maxHealth;
    private int cost;
    private String spriteFileName;
    private int demolitionCurrency;
    private ActionType actionType;
    private int actionRate;
    private int actionRange;

    private Map<ActionParameter, Float> actionParameters;
    private List<TowerUpgrade> upgrades;
    // добавить эффекты

}
