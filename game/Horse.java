package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

/**
 * Created by Romych on 24.02.2016.
 */
public class Horse {
    private Vector2 position;
    private float angle;



    private Vector2 velocity;

    private static Texture myTexture;

    
    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public static Texture getMyTexture() {
        return myTexture;
    }
    public static void setMyTexture(Texture myTexture) {
        Horse.myTexture = myTexture;
    }

    public void render(SpriteBatch batch){
        batch.draw(myTexture, position.x,position.y);
    }

    public Horse(Vector2 position, Vector2 velocity, float angle) {
        this.position = position;
        this.angle = angle;
        this.velocity = velocity;
    }

    public void update(){
        position.add(velocity);
        if (position.x<-myTexture.getWidth()) position.x=Gdx.graphics.getWidth();
        if (position.y>myTexture.getHeight()) position.y= Gdx.graphics.getHeight();
        if (position.x>Gdx.graphics.getWidth()) position.x=-myTexture.getWidth();
        if (position.y>Gdx.graphics.getHeight()) position.y=-myTexture.getHeight();

    }
}
