package com.mygdx.td.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.td.view.utils.Constants;

public class Tile extends Actor {

    private Texture texture;
    private Color color;

    public Tile(float x, float y) {
        this.color = Color.GREEN;
        createTexture(Constants.TILE_SIZE, Constants.TILE_SIZE, color);
        setX(x);
        setY(y);
        setWidth(Constants.TILE_SIZE);
        setHeight(Constants.TILE_SIZE);
        addListener(new InputListener(){
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Color currentColor = getColor();

                if (currentColor == Color.GREEN){
                    setColor(Color.YELLOW);
                }
                if (currentColor == Color.YELLOW){
                    setColor(Color.GRAY);
                }
                if (currentColor == Color.GRAY){
                    setColor(Color.BLUE);
                }
                if (currentColor == Color.BLUE){
                    setColor(Color.RED);
                }
                if (currentColor == Color.RED){
                    setColor(Color.GREEN);
                }
                createTexture(Constants.TILE_SIZE, Constants.TILE_SIZE, getColor());

                // tileX =
                // tileY =
                // mapController.changeTile(tileX, tileY, newColor)
                //менять тип ячейки в карте/ getX getY
            }
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    private void createTexture(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fillRectangle(0, 0, width, height);
        pixmap.setColor(color);
        pixmap.fillRectangle(1, 1, width - 2, height - 2);
        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public Color getColor(){
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
