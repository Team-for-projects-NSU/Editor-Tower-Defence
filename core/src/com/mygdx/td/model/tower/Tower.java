package com.mygdx.td.model.tower;

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


    private int id;
    private String name;
    private int maxHealth;
    private int cost;
    private String spriteName;
    private int demolitionCurrency;
    private ActionType actionType;
    private int actionRate;
    private int actionRange;

    public Map<String, Float> actionParams;
    private List<Integer> upgradeIDs;
    // добавить эффекты

}
