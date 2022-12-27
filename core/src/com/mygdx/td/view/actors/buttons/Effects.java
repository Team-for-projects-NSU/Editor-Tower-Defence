package com.mygdx.td.view.actors.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.td.TowerDefence;
import com.mygdx.td.view.actors.LeftBar;
import com.mygdx.td.view.utils.Constants;

public class Effects {
    private float width;
    private float height;
    private TextButton button;
    private LeftBar leftBar;

    public Effects(String buttonName, LeftBar leftBar){
        this.leftBar = leftBar;
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
