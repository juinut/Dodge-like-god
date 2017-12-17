package com.jui.gdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private DodgeLikeGodGame dodgeLikeGodGame;
	private World world;
	private Texture godImg;
	private Texture satanImg;
	private Texture blackholeImg;
	private Texture holyImg;
	private Texture goodThingImg;
	private Texture background;
	private SpriteBatch batch;
	public int randomCenter;
	public int randomQNumber;
	public int randomDNumber;
	public int countForCenter=1;
	public boolean satanMove = false;
	public boolean goodThingMove = false;
	private BitmapFont font;
	
	Random randomSatanSpeed = new Random();
	Random randomN = new Random();

	public WorldRenderer(DodgeLikeGodGame dodgeLikeGodGame, World world) {
        this.dodgeLikeGodGame = dodgeLikeGodGame;
        this.batch = this.dodgeLikeGodGame.batch;
 
        this.world = world;
        background = new Texture("bg.jpg");
        
        	blackholeImg = new Texture("wall.png");
        holyImg = new Texture("dot.png");
        
        godImg = new Texture("pacman.png");
        satanImg = new Texture("wall.png");
        goodThingImg = new Texture("pacman.png");
        
        font = new BitmapFont();
    }

	public void render(float delta) {
		SpriteBatch batch = dodgeLikeGodGame.batch;
		batch.begin();
		Vector2 posgod = world.getGod().getPosition();
		Vector2 possatan = world.getSatan().getPosition();
		Vector2 posgoodthing = world.getGoodThing().getPosition();
		batch.draw(background,0,0);
		if(countForCenter == 1) {
			randomCenter = randomSatanSpeed.nextInt(10);
			randomQNumber = randomN.nextInt(900) + 100;
			randomDNumber = randomN.nextInt(11) + 1;
			countForCenter+=1;
		}
		if(randomCenter%2==0) {
			batch.draw(blackholeImg, DodgeLikeGodGame.WIDTH/2,DodgeLikeGodGame.HEIGHT/2);
			satanMove = true;
		}
		else {
			batch.draw(holyImg, DodgeLikeGodGame.WIDTH/2,DodgeLikeGodGame.HEIGHT/2);
			goodThingMove = true;
		}
		batch.draw(godImg, posgod.x,DodgeLikeGodGame.HEIGHT-posgod.y);
		if(satanMove) {
			batch.draw(satanImg, possatan.x,DodgeLikeGodGame.HEIGHT-possatan.y);
		}
		else if(goodThingMove) {
			batch.draw(goodThingImg, posgoodthing.x,DodgeLikeGodGame.HEIGHT-posgoodthing.y);
		}
		font.draw(batch, "Q: " + randomQNumber, 500, 700);
		font.draw(batch, "" +randomDNumber, 525, 675);
		font.draw(batch, "Score: " + world.getScore(), 800, 700);
		font.draw(batch, "Your best score: " + world.getBestScore(), 800, 680);
		batch.end();
	}
}
