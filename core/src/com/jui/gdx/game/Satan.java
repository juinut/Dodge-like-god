package com.jui.gdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Satan {
	private Vector2 position;
	public int satanSpeedx;
	public int satanSpeedy;
	public int countForSatanSpeed=1;
	Random randomSatanSpeed = new Random();
	public Satan(float x, float y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    public void move() { 
    		
    		if(countForSatanSpeed==1){
    			satanSpeedx = randomSatanSpeed.nextInt(20) -10;
    			satanSpeedy = randomSatanSpeed.nextInt(20) -10;
    			countForSatanSpeed+=1;
    		}
    		position.x += satanSpeedx;
    		position.y += satanSpeedy;
    }
}
