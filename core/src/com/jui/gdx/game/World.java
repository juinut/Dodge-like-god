package com.jui.gdx.game;

public class World {
	private God god;
 
    public World(DodgeLikeGodGame dodgeLikeGodGame) {
        this.god = new God(500,675);
    }
 
    public God getGod() {
        return god;
    }
}
