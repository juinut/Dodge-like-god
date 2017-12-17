package com.jui.gdx.game;

public class World {
	private God god;
	private Satan satan;
	private GoodThing goodThing;
 
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
}
