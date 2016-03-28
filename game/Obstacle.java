package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Romych on 25.03.2016.
 */
public abstract class Obstacle {

    protected Vector2 position;

    public Vector2 getPosition() {
        return position;
    }

    public void draw(SpriteBatch batch){}

    public void update(){}

}
