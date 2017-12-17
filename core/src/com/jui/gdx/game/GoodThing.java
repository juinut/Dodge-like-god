package com.jui.gdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class GoodThing {
	private Vector2 position;
	public int GoodThingSpeedx;
	public int GoodThingSpeedy;
	public int countForGoodSpeed=1;
	Random randomGoodSpeed = new Random();
	public GoodThing(float x, float y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    public void move() { 
    		
    		if(countForGoodSpeed==1){
    			GoodThingSpeedx = randomGoodSpeed.nextInt(20) - 10;
    			GoodThingSpeedy= randomGoodSpeed.nextInt(20) - 10;
    			countForGoodSpeed+=1;
    		}
    		position.x += GoodThingSpeedx;
    		position.y += GoodThingSpeedy;
    }


}
