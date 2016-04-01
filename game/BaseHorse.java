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
    protected Vector2 velocity;
    protected Vector2 acceleration;
    protected float power;
    protected static Texture myTexture;
    protected float angle;
    protected float rotateSpeed;

    protected int sizeW;
    protected int sizeH;
    protected float moveX;
    protected float time;
    protected boolean life;
    protected int health;
    boolean jumped;
    int score;
    boolean overcome;
    boolean stuck;
    float currentTime;
    float nextTime;
    Vector2 direction;

    public BaseHorse() {
        //this.position=position;
        this.velocity=new Vector2(0.0f,0.0f);
        this.acceleration=new Vector2(0.0f,0.0f);
        this.angle = 0;
        this.life = true;
        this.rotateSpeed=0.1f;
        this.angle=0;
        this.jumped = false;
        this.overcome=false;
        this.score = 0;
        this.health = 100;
        this.stuck = false;
        this.power=0.1f;
        direction=new Vector2(0.0f,0.0f);
    }

    public abstract void draw(SpriteBatch batch);

    public Vector2 getPosition() {
        return position;
    }

    public void rotate(float a){
        angle+=a*rotateSpeed;
    }
    public void accelerate(){

        this.myTexture=new Texture("run_horse2_r.png");
        angle=0;
        rotate(angle);
        direction=new Vector2(1.0f,0.0f);
        acceleration=direction.rotate(angle).scl(power);
        velocity.add(acceleration);
    }

    public void slowDown(){
        angle=0;
        this.myTexture=new Texture("run_horse2_l.png");
        rotate(angle);
        direction=new Vector2(-1.0f,0.0f);
        acceleration=direction.rotate(angle).scl(power);
        velocity.add(acceleration);
    }

    public void fly(){
        //rotate(angle+5.0f);
        if(angle+5>-30&&angle+5<30){}
        else angle+=5;
        rotate(angle);
        direction=new Vector2(0.0f,1.0f);
        acceleration = direction.rotate(angle).scl(power);
        velocity.add(acceleration);
    }

    public void flyBack(){
        //rotate(angle+5.0f);
        if(angle+5>-30&&angle+5<30){}
        else angle+=5;
        rotate(angle);
        direction=new Vector2(0.0f,-1.0f);
        acceleration = direction.rotate(angle).scl(power);
        velocity.add(acceleration);
    }
    public void stop(){
        velocity.add(-velocity.x/2,-velocity.y/2).rotate(-angle).scl(power/10);
    }
    public void jumped(Obstacle obstacle){
            this.myTexture=new Texture("land_horse1_r.png");
            position.add(obstacle.sizeW,0);

    }
    //public void accelerate(){
    //    velocity.add(new Vector2(1.0f,0.0f).rotate(angle).scl(power));
    //}
    public void update() {
        //if (angle>-30&&angle<30)
          //  this.myTexture=
        position.add(velocity);
        //power-=0.01f;
        //velocity.scl(0,6f);
        //angle=0;

        if(position.x> Gdx.graphics.getWidth()) position.x = -sizeW/8;
        if(position.x<-sizeW/8) position.x=Gdx.graphics.getWidth();
        if(position.y>Gdx.graphics.getHeight()) position.y = -sizeH/8;
        if(position.y<-sizeH/8) position.y=Gdx.graphics.getHeight();
    }

}
