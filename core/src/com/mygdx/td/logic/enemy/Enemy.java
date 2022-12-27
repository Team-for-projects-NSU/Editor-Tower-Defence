package com.mygdx.td.logic.enemy;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enemy {

    public enum ActionType {
        BASE_ATTACK,
        TOWER_ATTACK,
        SUPPORT
        // ???
    }

    public enum ActionParameter {

    }

    private String name;
    private int maxHealth;
    private int reward;
    private String spriteFileName;
    private int speed;
    private ActionType actionType;
    private int actionRate;
    private int actionRange;
    private Map<ActionParameter, Float> actionParameters;

    public void addActionParameter(ActionParameter parameter, float value) {
        actionParameters.put(parameter, value);
    }
}
