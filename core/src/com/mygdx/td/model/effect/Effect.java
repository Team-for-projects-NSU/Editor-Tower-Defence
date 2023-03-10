package com.mygdx.td.model.effect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Effect {

    private String name;
    private int rate;
    private int duration;
}
