package com.jui.gdx.game;

public class World {
	private God god;
	private Satan satan;
	private GoodThing goodThing;
	public int score = 0;
	public int bestScore = 0;
 
    public World(DodgeLikeGodGame dodgeLikeGodGame) {
        this.god = new God(500,675);
        this.satan = new Satan(DodgeLikeGodGame.WIDTH/2,DodgeLikeGodGame.HEIGHT/2);
        this.goodThing = new GoodThing(DodgeLikeGodGame.WIDTH/2,DodgeLikeGodGame.HEIGHT/2);
    }
 
    public God getGod() {
        return god;
    }
    public Satan getSatan() {
    		return satan;
    }
    public GoodThing getGoodThing() {
    		return goodThing;
    }
    public int getScore() {
    		return score;
    }
    public int getBestScore() {
    		return bestScore;
    }
}
