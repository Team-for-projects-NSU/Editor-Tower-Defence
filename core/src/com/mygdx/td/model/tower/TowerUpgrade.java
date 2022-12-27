package com.mygdx.td.model.tower;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TowerUpgrade {
    private int price;
    private Map<Tower.ActionParameter, Float> modifiers;
}
