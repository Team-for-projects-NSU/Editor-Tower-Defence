package com.mygdx.td;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.td.visual.screens.MainScreen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TowerDefence extends Game {
	static public Skin appSkin;

	@Override
	public void create () {
		appSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		this.setScreen(new MainScreen());
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}

