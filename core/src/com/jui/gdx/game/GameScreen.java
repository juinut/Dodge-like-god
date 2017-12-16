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
	private DodgeLikeGodGame dodgeLikeGodGame;
	
    public GameScreen(DodgeLikeGodGame dodgeLikeGodGame) {
        this.dodgeLikeGodGame = dodgeLikeGodGame;
        new Texture("pacman.png");
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
    private void update(float delta) {
    		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    			world.getGod().move(God.DIRECTION_ANTICLOCKWISE);
        }
    		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        		world.getGod().move(God.DIRECTION_CLOCKWISE);
        }
    }
}
