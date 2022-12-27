package com.mygdx.td.view.actors;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.td.TowerDefence;
import com.mygdx.td.view.actors.buttons.CreateMap;
import com.mygdx.td.view.utils.Constants;

public class MapEditor {
    private Group group;
    private Group map;
    TextField mapWidth;
    TextField mapHeight;
    public MapEditor(){
        group = new Group();
        Rectangle settingRec = new Rectangle(0, 0,
                Constants.SETTING_WINDOW_WIDTH, Constants.SETTING_WINDOW_HEIGHT, Color.GRAY);
        group.addActor(settingRec);
        mapWidth = new TextField("", TowerDefence.appSkin);
        mapWidth.setPosition(Constants.SETTING_WINDOW_WIDTH - 200, Constants.SETTING_WINDOW_HEIGHT - 100);
        group.addActor(mapWidth);
        mapHeight = new TextField("", TowerDefence.appSkin);
        mapHeight.setPosition(Constants.SETTING_WINDOW_WIDTH - 200, Constants.SETTING_WINDOW_HEIGHT - 200);
        group.addActor(mapHeight);
        CreateMap createMap = new CreateMap("Create", this);
        createMap.getButton().setPosition(Constants.SETTING_WINDOW_WIDTH - 200, Constants.SETTING_WINDOW_HEIGHT - 300);
        group.addActor(createMap.getButton());
        group.setPosition(Constants.SETTING_WINDOW_X, Constants.SETTING_WINDOW_Y);
    }

    public void addMap(){
        int width = Integer.parseInt(mapWidth.getText());
        int height = Integer.parseInt(mapHeight.getText());
        //LevelMap создать пустую карту по ширине высоте
        map = new Group();
        for (int i = 0; i < width * Constants.TILE_SIZE; i = i + Constants.TILE_SIZE){
            for (int j = 0; j < height * Constants.TILE_SIZE; j = j + Constants.TILE_SIZE){
                Tile tile = new Tile(i, j);
                map.addActor(tile);
            }
        }
        group.addActor(map);

        // mapController.addMap(width, height)
    }
    public Group getGroup() {
        return group;
    }
}
