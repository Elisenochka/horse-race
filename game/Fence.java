package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;



/**
 * Created by Romych on 25.03.2016.
 */
public class Fence extends Obstacle{
    private static Texture texture;


    public Fence(Vector2 position){
        this.position=position;
        //if(myTexture==null)
        //myTexture = new Texture("obstacle.png");
        texture=new Texture("fence.png");
        this.position=position;
        sizeH=texture.getHeight();
        sizeW=texture.getWidth();
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture,position.x,position.y,100,texture.getHeight()/5,texture.getWidth(),texture.getHeight(),1.0f,1.0f,0,0,0,texture.getWidth(),texture.getHeight(),false,false);
    }
    public void update(){
        super.update();
    }
}
