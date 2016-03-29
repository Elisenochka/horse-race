package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.physics.box2d.World;


import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	//Texture img;
	//Horse horse = new Horse(new Vector2(100,100),new Vector2(10,10),10);
	BaseHorse[] horses = new BaseHorse[10];
	Obstacle[] fence = new Obstacle[5];
	//Obstacle ob = new Obstacle(new Vector2());
	public static Random rand = new Random();
	//PlayerHorse h1;
	float x;
	float y;
	//private World world;

	private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//Fence fence = new Fence();
		//camera = new OrthographicCamera();
		//camera.setToOrtho(false,w/2,h/2);
		horses[0] = new PlayerHorse(new Vector2(100,100));
		//Horse.setMyTexture(new Texture("broodmare_horse.png"));
		for(int i =1;i<horses.length;i++){
			horses[i]=new BotHorse(new Vector2(rand.nextInt(Gdx.graphics.getWidth()),rand.nextInt(Gdx.graphics.getHeight())));
		}
		for(int i =0;i<fence.length;i++){
			fence[i]=new Fence(new Vector2(rand.nextInt(Gdx.graphics.getWidth()), rand.nextInt(Gdx.graphics.getHeight()))) {
			};
		}

	}

	@Override
	public void render () {
		update();
		//update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//fence.draw(batch);

		//horse.render(batch);
		for(int i =0;i<horses.length;i++){
			horses[i].draw(batch);
		}
		for(int i =0;i<fence.length;i++){
			fence[i].draw(batch);
		}


		//batch.draw(horse, horse.(), horse.getY());

		batch.end();
	}

	public void update(){
		//fence.update();
		for (int i = 0; i < horses.length; i++) {
			if(horses[i].life=true){
				horses[i].update();
			}
		}
		for(int j = 0;j<fence.length;j++) {
			Vector2 vlen = horses[0].getPosition().cpy().sub(fence[j].getPosition());
			float flen = vlen.len();
			if (flen<10&&horses[0].jumped==true){
				horses[0].score+=1;
			}
			else {
				horses[0].health-=1;
				//horses[0].stuck=true;
			}
		}




		/*horse.update();
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			horse.getPosition().y++;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			horse.getPosition().y--;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			horse.getPosition().x++;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			horse.getPosition().x--;
		}*/
		//x++;
		//y++;
	}

	public void realize(int width,int height){
		camera.setToOrtho(false,width/2,height/2);
	}

}
