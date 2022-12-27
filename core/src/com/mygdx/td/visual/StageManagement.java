package com.mygdx.td.visual;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.td.visual.actors.LeftBar;
import com.mygdx.td.visual.actors.MapEditor;

public class StageManagement {
    private Stage appStage;
    private MapEditor mapEditor;
    private LeftBar leftBar;

    public StageManagement(Stage appStage){
        this.appStage = appStage;
        mapEditor = new MapEditor();
        leftBar = new LeftBar();
        this.appStage.addActor(mapEditor.getGroup());
        this.appStage.addActor(leftBar.getGroup());

    }
}
