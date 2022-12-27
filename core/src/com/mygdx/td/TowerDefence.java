package com.mygdx.td;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.td.controller.Controller;
import com.mygdx.td.view.screens.MainScreen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TowerDefence extends Game {
	static public Skin appSkin;
	public Controller controller;

	@Override
	public void create () {
		controller = new Controller();

		appSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		this.setScreen(new MainScreen());
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}

