package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Romych on 25.03.2016.
 */
public class BotHorse extends BaseHorse {

    private enum BotState{
        FLY_FW,RUN_FW,RUN_BW
    }

    private static Texture myTexture;
    BotState action;

    public BotHorse(Vector2 position){
        super();
        if(myTexture==null)
        myTexture = new Texture("run_horse_r.png");
        this.position=position;
        currentTime = 0.0f;
        nextTime = 0.0f;
        action=BotState.RUN_FW;
        power=1.5f;
        this.angle=0;
        this.rotateSpeed =1;
        sizeH=myTexture.getHeight();
        sizeW=myTexture.getWidth();
        moveX = 1.0f;

    }
    public void slowDown() {
        super.slowDown();
        if(MyGdxGame.rand.nextInt()==1)
            myTexture = new Texture("run_horse3_l.png");
        else myTexture = new Texture("run_horse2_l.png");
    }

    public void accelerate() {
        super.accelerate();
        if(MyGdxGame.rand.nextInt()==1)
            myTexture = new Texture("run_horse3_r.png");
        else myTexture = new Texture("run_horse_r.png");
    }

    public void draw(SpriteBatch batch){
        batch.draw(myTexture,position.x,position.y,myTexture.getWidth()/2,myTexture.getHeight()/2,myTexture.getWidth(),myTexture.getHeight(),1.0f,1.0f,angle,0,0,myTexture.getWidth(),myTexture.getHeight(),false,false);
    }
    public void update(){
        super.update();
        switch (action){
            case FLY_FW:
                fly();
                break;
            case RUN_FW:
                accelerate();
                break;
            case RUN_BW:
                slowDown();
                break;

        }
        //accelerate();

        currentTime += Gdx.graphics.getDeltaTime();
        if(currentTime>nextTime){
            nextTime = 1.0f+MyGdxGame.rand.nextFloat()*1.0f;
            currentTime=0;
            action=BotState.values()[MyGdxGame.rand.nextInt(3)];

        }
    }




}
