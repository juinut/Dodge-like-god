package com.jui.gdx.game;

public class World {
	private God god;
    private DodgeLikeGodGame dodgeLikeGodGame;
 
    World(DodgeLikeGodGame dodgeLikeGodGame) {
        this.dodgeLikeGodGame = dodgeLikeGodGame;
 
        god = new God(500,675);
    }
 
    God getGod() {
        return god;
    }
}
