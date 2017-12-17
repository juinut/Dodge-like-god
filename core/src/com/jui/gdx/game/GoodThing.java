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
    			while(true) {
    				GoodThingSpeedx = randomGoodSpeed.nextInt(3) - 1;
    				GoodThingSpeedy= randomGoodSpeed.nextInt(3) - 1;
    				if(GoodThingSpeedx != 0 && GoodThingSpeedy != 0) {
    					break;
    				}
    			}
    			countForGoodSpeed+=1;
    		}
    		position.x += GoodThingSpeedx;
    		position.y += GoodThingSpeedy;
    }


}
