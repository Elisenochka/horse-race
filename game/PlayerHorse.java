package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Timer;

/**
 * Created by Romych on 24.03.2016.
 */
public class PlayerHorse extends BaseHorse {
    private static Texture myTexture;
    //private Obstacle obstacle;

    public static Texture getMyTexture() {
        return myTexture;
    }

    public PlayerHorse(Vector2 position) {
        super();
        myTexture = new Texture("run_horse2_r.png");
        this.position = position;
        sizeH = myTexture.getHeight();
        sizeW = myTexture.getWidth();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(myTexture, position.x, position.y, myTexture.getWidth()/2, myTexture.getHeight()/2, myTexture.getWidth(), myTexture.getHeight(), 1.0f, 1.0f, angle, 0, 0, myTexture.getWidth(), myTexture.getHeight(), false, false);
    }

    public void slowDown() {
        super.slowDown();
        myTexture = new Texture("run_horse2_l.png");
    }

    public void accelerate() {
        super.accelerate();
        myTexture = new Texture("run_horse2_r.png");
    }

    public void fly(){
        super.fly();
        myTexture = new Texture("run_horse3_r.png");
    }

    public void flyBack(){
        super.flyBack();
        myTexture = new Texture("run_horse3_l.png");
    }

    public void jump() {
        myTexture = new Texture("jump_horse_r.png");
    }

    public void fall() {
        myTexture = new Texture("lying_horse_r.png");
    }


    public void update() {
        //super.update(fence);
        super.update();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            //myTexture = new Texture("horse_L_1sm.png");
            //setXPoint=myTexture.getWidth()/5;
            //moveX=-2.0f;
            //SpriteBatch batch = new SpriteBatch();
            //drawL(batch);
            //rotate(1.0f);
            slowDown();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            //myTexture = new Texture("run_horse_r.png");
            //setXPoint=myTexture.getWidth()*4/5;
            //moveX=1.0f;
            //SpriteBatch batch = new SpriteBatch();
            //drawR(batch);
            //rotate(-1.0f);
            accelerate();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            //moveForward();
            fly();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            //moveForward();
            flyBack();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            jump();
            this.jumped = true;
        }
        //if(this.stuck==true){
        //    fall();
        //}




    }
}



