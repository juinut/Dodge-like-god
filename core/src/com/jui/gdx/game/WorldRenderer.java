package com.jui.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private DodgeLikeGodGame dodgeLikeGodGame;
	private World world;
	private God god;
	private Texture godImg;
	private SpriteBatch batch;

	public WorldRenderer(DodgeLikeGodGame dodgeLikeGodGame, World world) {
        this.dodgeLikeGodGame = dodgeLikeGodGame;
        this.batch = this.dodgeLikeGodGame.batch;
 
        this.world = world;
 
        godImg = new Texture("pacman.png");
    }

	public void render(float delta) {
		SpriteBatch batch = dodgeLikeGodGame.batch;
		batch.begin();
		Vector2 pos = god.getPosition();
		batch.draw(godImg, pos.x,750-pos.y);
		batch.end();
	}
}
