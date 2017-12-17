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
    public boolean isDead() {
    		if(abs(world.getSatan().getPosition().x-world.getGod().getPosition().x) <=30 && abs(world.getSatan().getPosition().y -world.getGod().getPosition().y)<=30) {
    			return true;
    		}
    		else
    			return false;
    }
    private void update(float delta) {
    		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    			world.getGod().move(God.DIRECTION_ANTICLOCKWISE);
        }
    		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        		world.getGod().move(God.DIRECTION_CLOCKWISE);
        }
    		if(world.getSatan().getPosition().x >= DodgeLikeGodGame.WIDTH || world.getSatan().getPosition().y >= DodgeLikeGodGame.HEIGHT) {
    			world.getSatan().getPosition().x = DodgeLikeGodGame.WIDTH/2;
    			world.getSatan().getPosition().y = DodgeLikeGodGame.HEIGHT/2;
    		}
    		if(!isDead()) {
    			world.getSatan().move();
    			System.out.println("xs"+world.getSatan().getPosition().x);
    			System.out.println("xg"+world.getGod().getPosition().x);
    			System.out.println("ys"+world.getSatan().getPosition().y);
    			System.out.println("yg"+world.getGod().getPosition().y);
    		}
    		if(isDead())
    		{
    			System.out.println("dead");
    			System.out.println("xs"+world.getSatan().getPosition().x);
    			System.out.println("xg"+world.getGod().getPosition().x);
    			System.out.println("ys"+world.getSatan().getPosition().y);
    			System.out.println("yg"+world.getGod().getPosition().y);
    		}
    }
}
