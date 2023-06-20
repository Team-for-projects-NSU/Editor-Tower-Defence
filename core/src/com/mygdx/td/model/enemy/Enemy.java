package com.mygdx.td.model.enemy;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enemy {

    public enum ActionType {
        Default,
        DoNothing,
        BasicAttack,
    }

    private int id;
    private String name;
    private int maxHealth;
    private int reward;
    private String spriteFileName;
    private int speed;
    private ActionType actionType;
    private float actionRate;
    private int actionRange;
    private Map<String, Float> actionParameters;

    public void addActionParameter(String parameter, float value) {
        actionParameters.put(parameter, value);
    }
}
