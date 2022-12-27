package com.mygdx.td.view.actors;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.td.TowerDefence;
import com.mygdx.td.view.StageManagement;
import com.mygdx.td.view.actors.buttons.CreateMap;
import com.mygdx.td.view.utils.Constants;
import com.sun.tools.javac.util.StringUtils;

public class MapEditor {
    public StageManagement stageManagement;
    private Group group;
    private Group map;
    TextField mapWidth;
    TextField mapHeight;
    public MapEditor(StageManagement stageManagement){
        this.stageManagement = stageManagement;
        group = new Group();
        Rectangle settingRec = new Rectangle(0, 0,
                Constants.SETTING_WINDOW_WIDTH, Constants.SETTING_WINDOW_HEIGHT, Color.GRAY);
        group.addActor(settingRec);
        Label textWidth = new Label("Width", TowerDefence.appSkin);
        textWidth.setColor(Color.BLACK);
        textWidth.setPosition(Constants.SETTING_WINDOW_WIDTH - 200, Constants.SETTING_WINDOW_HEIGHT - 45);
        group.addActor(textWidth);
        mapWidth = new TextField("", TowerDefence.appSkin);
        mapWidth.setPosition(Constants.SETTING_WINDOW_WIDTH - 200, Constants.SETTING_WINDOW_HEIGHT - 100);
        group.addActor(mapWidth);
        Label textHeight = new Label("Height", TowerDefence.appSkin);
        textHeight.setColor(Color.BLACK);
        textHeight.setPosition(Constants.SETTING_WINDOW_WIDTH - 200, Constants.SETTING_WINDOW_HEIGHT - 145);
        group.addActor(textHeight);
        mapHeight = new TextField("", TowerDefence.appSkin);
        mapHeight.setPosition(Constants.SETTING_WINDOW_WIDTH - 200, Constants.SETTING_WINDOW_HEIGHT - 200);
        group.addActor(mapHeight);
        CreateMap createMap = new CreateMap("Create", this);
        createMap.getButton().setPosition(Constants.SETTING_WINDOW_WIDTH - 200, Constants.SETTING_WINDOW_HEIGHT - 300);
        group.addActor(createMap.getButton());
        Label green = new Label("Green: empty", TowerDefence.appSkin);
        green.setColor(Color.BLACK);
        Label yellow = new Label("Yellow: path", TowerDefence.appSkin);
        yellow.setColor(Color.BLACK);
        Label gray = new Label("Gray: towers", TowerDefence.appSkin);
        gray.setColor(Color.BLACK);
        Label blue = new Label("Blue: base", TowerDefence.appSkin);
        blue.setColor(Color.BLACK);
        Label red = new Label("Red: spawn", TowerDefence.appSkin);
        red.setColor(Color.BLACK);
        green.setPosition(Constants.SETTING_WINDOW_WIDTH - 270, Constants.SETTING_WINDOW_HEIGHT - 400);
        yellow.setPosition(Constants.SETTING_WINDOW_WIDTH - 270, Constants.SETTING_WINDOW_HEIGHT - 450);
        gray.setPosition(Constants.SETTING_WINDOW_WIDTH - 270, Constants.SETTING_WINDOW_HEIGHT - 500);
        blue.setPosition(Constants.SETTING_WINDOW_WIDTH - 270, Constants.SETTING_WINDOW_HEIGHT - 550);
        red.setPosition(Constants.SETTING_WINDOW_WIDTH - 270, Constants.SETTING_WINDOW_HEIGHT - 600);
        group.addActor(green);
        group.addActor(yellow);
        group.addActor(gray);
        group.addActor(blue);
        group.addActor(red);
        group.setPosition(Constants.SETTING_WINDOW_X, Constants.SETTING_WINDOW_Y);
    }

    public void addMap(){
        int width;
        int height;
        try {
            width = Integer.parseInt(mapWidth.getText());
        } catch (NumberFormatException nfe){
            width = 10;
        }
        try {
            height = Integer.parseInt(mapHeight.getText());
        } catch (NumberFormatException nfe){
            height = 10;
        }
        //LevelMap создать пустую карту по ширине высоте
        map = new Group();
        for (int i = 0; i < width * Constants.TILE_SIZE; i = i + Constants.TILE_SIZE){
            for (int j = 0; j < height * Constants.TILE_SIZE; j = j + Constants.TILE_SIZE){
                Tile tile = new Tile(i, j, this);
                map.addActor(tile);
            }
        }
        map.setPosition(Constants.TILE_SIZE, Constants.TILE_SIZE);
        group.addActor(map);
        stageManagement.towerDefence.controller.getMapController().addMap(width, height);
    }
    public Group getGroup() {
        return group;
    }
}
