package com.jui.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private DodgeLikeGodGame dodgeLikeGodGame;
	private World world;
	private Texture godImg;
	private Texture satanImg;
	private SpriteBatch batch;

	public WorldRenderer(DodgeLikeGodGame dodgeLikeGodGame, World world) {
        this.dodgeLikeGodGame = dodgeLikeGodGame;
        this.batch = this.dodgeLikeGodGame.batch;
 
        this.world = world;
 
        godImg = new Texture("pacman.png");
        satanImg = new Texture("pacman.png");
    }

	public void render(float delta) {
		SpriteBatch batch = dodgeLikeGodGame.batch;
		batch.begin();
		Vector2 posgod = world.getGod().getPosition();
		Vector2 possatan = world.getSatan().getPosition();
		batch.draw(godImg, posgod.x,DodgeLikeGodGame.HEIGHT-posgod.y);
		batch.draw(satanImg, possatan.x,DodgeLikeGodGame.HEIGHT-possatan.y);
		batch.end();
	}
}
