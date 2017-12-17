package com.jui.gdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Satan {
	private Vector2 position;
	public Satan(float x, float y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    public void move() { 
    		Random randomSatanSpeed = new Random();
    		position.x += randomSatanSpeed.nextInt(10);
    		position.y += randomSatanSpeed.nextInt(10);
    }

}
