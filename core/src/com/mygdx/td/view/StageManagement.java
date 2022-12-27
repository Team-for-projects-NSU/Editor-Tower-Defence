package com.mygdx.td.view;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.td.TowerDefence;
import com.mygdx.td.view.actors.LeftBar;
import com.mygdx.td.view.actors.MapEditor;

public class StageManagement {
    private Stage appStage;
    public TowerDefence towerDefence;
    private MapEditor mapEditor;
    private LeftBar leftBar;

    public StageManagement(Stage appStage, TowerDefence towerDefence){
        this.appStage = appStage;
        this.towerDefence = towerDefence;
        mapEditor = new MapEditor(this);
        leftBar = new LeftBar(this);
        this.appStage.addActor(mapEditor.getGroup());
        this.appStage.addActor(leftBar.getGroup());

    }
}
