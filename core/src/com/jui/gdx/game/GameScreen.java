package com.jui.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private WorldRenderer worldRenderer;
	private World world;
	
	
    public GameScreen(DodgeLikeGodGame dodgeLikeGodGame) {
        world = new World(dodgeLikeGodGame);
        worldRenderer = new WorldRenderer(dodgeLikeGodGame,world);
    }
    @Override
    public void render(float delta) {
        update(delta);
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        worldRenderer.render(delta);
    }
    public float abs(float n) {
    		if(n<0) {
    			return (n*(-1));
    		}
    		else
    			return n;
    }
    public boolean touchingGoodThing() {
    		if(abs(world.getGoodThing().getPosition().x-world.getGod().getPosition().x) <=30 && abs(world.getGoodThing().getPosition().y -world.getGod().getPosition().y)<=30) {
    			return true;
    		}
    		else {
    			return false;
    		}
    }
    public boolean touchingSatan() {
    		if(abs(world.getSatan().getPosition().x-world.getGod().getPosition().x) <=30 && abs(world.getSatan().getPosition().y -world.getGod().getPosition().y)<=30) {
			return true;
		}
		else {
			return false;
		}
    }
    public boolean theEnd(){
    		if(world.score<0) {
    			return true;
    		}
    		else {
    			return false;
    		}
    }
    private void update(float delta) {
    		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    			world.getGod().move(God.DIRECTION_ANTICLOCKWISE);
        }
    		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        		world.getGod().move(God.DIRECTION_CLOCKWISE);
        }
    		if(Gdx.input.isKeyPressed(Keys.A)) {
    			world.score = 0;
        }
    		if((world.getSatan().getPosition().x >= DodgeLikeGodGame.WIDTH || world.getSatan().getPosition().y >= DodgeLikeGodGame.HEIGHT || world.getSatan().getPosition().x <= 0 || world.getSatan().getPosition().y <= 0) && worldRenderer.satanMove) {
    			world.getSatan().getPosition().x = DodgeLikeGodGame.WIDTH/2;
    			world.getSatan().getPosition().y = DodgeLikeGodGame.HEIGHT/2;
    			if(worldRenderer.randomQNumber % worldRenderer.randomDNumber == 0) {
					world.score-=worldRenderer.randomDNumber;
			}
			else {
					world.score+=(worldRenderer.randomDNumber/2);
			}
    			world.getSatan().countForSatanSpeed = 1;
    			worldRenderer.countForCenter = 1;
    			worldRenderer.satanMove = false;
    		}
    		if((world.getGoodThing().getPosition().x >= DodgeLikeGodGame.WIDTH || world.getGoodThing().getPosition().y >= DodgeLikeGodGame.HEIGHT || world.getGoodThing().getPosition().x <= 0 || world.getGoodThing().getPosition().y <= 0 ) && worldRenderer.goodThingMove) {
    			world.getGoodThing().getPosition().x = DodgeLikeGodGame.WIDTH/2;
    			world.getGoodThing().getPosition().y = DodgeLikeGodGame.HEIGHT/2;
    			if(worldRenderer.randomQNumber % worldRenderer.randomDNumber == 0) {
    				world.score-=(worldRenderer.randomDNumber/2);
    			}
    			else {
    				world.score+=(worldRenderer.randomDNumber*2);
    			}
    			world.getGoodThing().countForGoodSpeed = 1;
    			worldRenderer.countForCenter = 1;
    			worldRenderer.goodThingMove = false;
		}
    		if(touchingSatan()){
    			if(worldRenderer.randomQNumber % worldRenderer.randomDNumber == 0) {
    				world.score+=(worldRenderer.randomDNumber/2);
    			}
    			else {
    				world.score-=worldRenderer.randomDNumber;
    			}
    			world.getSatan().getPosition().x = DodgeLikeGodGame.WIDTH/2;
    			world.getSatan().getPosition().y = DodgeLikeGodGame.HEIGHT/2;
    			world.getSatan().countForSatanSpeed = 1;
    			worldRenderer.countForCenter = 1;
    			worldRenderer.satanMove = false;
    		}
    		if(touchingGoodThing()) {
    			if(worldRenderer.randomQNumber % worldRenderer.randomDNumber == 0) {
    				world.score+=(worldRenderer.randomDNumber*2);
    			}
    			else {
    				world.score-=(worldRenderer.randomDNumber/2);
    			}
    			world.getGoodThing().getPosition().x = DodgeLikeGodGame.WIDTH/2;
    			world.getGoodThing().getPosition().y = DodgeLikeGodGame.HEIGHT/2;
    			world.getGoodThing().countForGoodSpeed = 1;
    			worldRenderer.countForCenter = 1;
    			worldRenderer.goodThingMove = false;
    		}
    		if(!theEnd()) {
    			if(worldRenderer.satanMove) {
    				world.getSatan().move();
    			}
    			else if(worldRenderer.goodThingMove) {
    				world.getGoodThing().move();
    			}
    		}
    		if(world.bestScore<=world.score) {
    			world.bestScore = world.score;
    		}
    }
}
