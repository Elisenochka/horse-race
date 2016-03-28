package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Romych on 25.03.2016.
 */
public class BotHorse extends BaseHorse {
    private static Texture myTexture;


    public BotHorse(Vector2 position){
        if(myTexture==null)
        myTexture = new Texture("run_horse_r.png");
        this.position=position;
        this.angle=0;
        rotateSpeed=1.0f;
        moveSpeed=2.0f;
        setXPoint=myTexture.getWidth()*4/5;
        sizeH=myTexture.getHeight();
        sizeW=myTexture.getWidth();
        moveX = 1.0f;

    }

    public void draw(SpriteBatch batch){
        batch.draw(myTexture,position.x,position.y,setXPoint,myTexture.getHeight()/5,myTexture.getWidth(),myTexture.getHeight(),1.0f,1.0f,angle,0,0,myTexture.getWidth(),myTexture.getHeight(),false,false);
    }

    public void update() {
        super.update();
        if(angle>90&&angle<00){
            myTexture = new Texture("horse_L_1smCopy.png");
        }
        rotate(MyGdxGame.rand.nextFloat()-0.5f);
        moveForward();
    }



}
