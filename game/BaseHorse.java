package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import sun.java2d.windows.GDIBlitLoops;

/**
 * Created by Romych on 24.03.2016.
 */
public abstract class BaseHorse {
    protected Vector2 position;
    protected float angle;
    protected float rotateSpeed;
    protected float moveSpeed;
    protected float setXPoint;
    protected float sizeW;
    protected float sizeH;
    protected float moveX;
    protected float time;
    protected float velocity;
    protected float power;


    public abstract void draw(SpriteBatch batch);

    public Vector2 getPosition() {
        return position;
    }

    public void rotate(float a){
        angle+=a*rotateSpeed;
    }
    public void moveForward(){
        position.add(new Vector2(1.0F, 0.0f).rotate(angle).scl(moveSpeed));
    }
    //public void accelerate(){
    //    velocity.add(new Vector2(1.0f,0.0f).rotate(angle).scl(power));
    //}
    public void update(){
        if(position.x> Gdx.graphics.getWidth()) position.x = -sizeW/5;
        if(position.x<-sizeW/5) position.x=Gdx.graphics.getWidth();
        if(position.y>Gdx.graphics.getHeight()) position.y = -sizeH/5;;
        if(position.y<-sizeH/5) position.y=Gdx.graphics.getHeight();
    }
}
