package com.jui.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private DodgeLikeGodGame dodgeLikeGodGame;
	private Texture godImg;
	private God god;
	 
    public GameScreen(DodgeLikeGodGame dodgeLikeGodGame) {
        this.dodgeLikeGodGame = dodgeLikeGodGame;
        godImg = new Texture("pacman.png");
        god = new God(500,675);
    }
    @Override
    public void render(float delta) {
    		Gdx.gl.glClearColor(0, 0, 0, 1);
    		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    		SpriteBatch batch = dodgeLikeGodGame.batch;
    		update(delta);
        batch.begin();
        Vector2 pos = god.getPosition();
        batch.draw(godImg, pos.x,750-pos.y);
        batch.end();
    }
    private void update(float delta) {
    		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    			god.move(God.DIRECTION_ANTICLOCKWISE);
        }
    		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        		god.move(God.DIRECTION_CLOCKWISE);
        }
    }
}
