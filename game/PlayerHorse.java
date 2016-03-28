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
public class PlayerHorse extends BaseHorse{
    private static Texture myTexture;
    //private Obstacle obstacle;

    public static Texture getMyTexture() {
        return myTexture;
    }

    public PlayerHorse(Vector2 position){
        myTexture = new Texture("run_horse_r.png");

        this.position=position;
        this.angle=10;
        rotateSpeed=1.0f;
        moveSpeed=3.0f;
        setXPoint=myTexture.getWidth()*4/5;
        sizeH=myTexture.getHeight();
        sizeW=myTexture.getWidth();
        moveX = 1.0f;

    }
    public void draw(SpriteBatch batch){
        batch.draw(myTexture,position.x,position.y,setXPoint,myTexture.getHeight()*4/5,myTexture.getWidth(),myTexture.getHeight(),1.0f,1.0f,angle,0,0,myTexture.getWidth(),myTexture.getHeight(),false,false);
    }

    public void update(Fence fence){
        super.update();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            //myTexture = new Texture("horse_L_1sm.png");
            //setXPoint=myTexture.getWidth()/5;
            moveX=-2.0f;
            //SpriteBatch batch = new SpriteBatch();
            //drawL(batch);
            rotate(1.0f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            //myTexture = new Texture("run_horse_r.png");
            //setXPoint=myTexture.getWidth()*4/5;
            moveX=1.0f;
            //SpriteBatch batch = new SpriteBatch();
            //drawR(batch);
            rotate(-1.0f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            moveForward();
        }

        /*if(this.position.x<fence.getPosition().x+50&&this.position.x>fence.getPosition().x-50){
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){

            }
            else
            //wait(10000);

                myTexture = new Texture("lying_horse_r");
            //TimeUtils.nanoTime();
            moveSpeed=0;


        }*/



    }


}
