package com.mygdx.td.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.td.view.actors.buttons.Effects;
import com.mygdx.td.view.actors.buttons.Entities;
import com.mygdx.td.view.actors.buttons.Map;
import com.mygdx.td.view.utils.Constants;

public class LeftBar {
    Group group;
    public LeftBar() {
        group = new Group();
        Rectangle settingRec = new Rectangle(0, 0,
                Constants.SETTING_WINDOW_X - 2 * Constants.SETTING_WINDOW_Y,
                Constants.APP_HEIGHT - Constants.SETTING_WINDOW_Y * 2,
                Color.GRAY);
        group.addActor(settingRec);
        Entities entities = new Entities("Entities", this);
        Map map = new Map("Map", this);
        Effects effects = new Effects("Effects", this);
        entities.getButton().setPosition((settingRec.getWidth() - entities.getButton().getWidth()) / 2,
                Constants.APP_HEIGHT - Constants.SETTING_WINDOW_Y * 4);
        map.getButton().setPosition((settingRec.getWidth() - map.getButton().getWidth()) / 2,
                Constants.APP_HEIGHT - Constants.SETTING_WINDOW_Y * 6);
        effects.getButton().setPosition((settingRec.getWidth() - effects.getButton().getWidth()) / 2,
                Constants.APP_HEIGHT - Constants.SETTING_WINDOW_Y * 8);
        group.addActor(entities.getButton());
        group.addActor(map.getButton());
        group.addActor(effects.getButton());
        group.setPosition(Constants.SETTING_WINDOW_Y, Constants.SETTING_WINDOW_Y);
    }

    public Group getGroup() {
        return group;
    }
}
