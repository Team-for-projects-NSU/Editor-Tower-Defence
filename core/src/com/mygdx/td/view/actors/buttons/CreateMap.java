package com.mygdx.td.view.actors.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.td.TowerDefence;
import com.mygdx.td.view.actors.MapEditor;
import com.mygdx.td.view.utils.Constants;

public class CreateMap {
    private float width;
    private float height;
    private TextButton button;
    private MapEditor mapEditor;

    public CreateMap(String buttonName, MapEditor mapEditor){
        this.mapEditor = mapEditor;
        button = new TextButton(buttonName, TowerDefence.appSkin);
        setHeight((new TextButton("", TowerDefence.appSkin)).getHeight());
        setWidth(Constants.APP_WIDTH / 100 * 11);
        button.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                touched();
            }
        });
    }
    public void touched() {
        mapEditor.addMap();
    }
    private void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
        button.setWidth(width);
    }

    public TextButton getButton() {
        return button;
    }
}
