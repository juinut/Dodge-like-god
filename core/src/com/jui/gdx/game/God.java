package com.jui.gdx.game;

import com.badlogic.gdx.math.Vector2;

public class God {
	private Vector2 position;
	private int angle=0;
	private float speed=0.07f;
	private int radius = 325;
	private int centerx = 500;
	private int centery = 375;
	public static final int DIRECTION_CLOCKWISE = 1;
    public static final int DIRECTION_ANTICLOCKWISE = 2;
    public static final int DIRECTION_STILL = 0;
    
	 
    public God(float x, float y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    public void move(int dir) { 
        switch(dir) {
        case DIRECTION_CLOCKWISE:
        		angle-=1;
        		position.x =(float)(centerx-radius*Math.sin(angle*speed));
        		position.y =(float)(centery+radius*Math.cos(angle*speed));
            break;
        case DIRECTION_ANTICLOCKWISE:
        		angle+=1;
            position.x =(float)(centerx-radius*Math.sin(angle*speed));
            position.y =(float)(centery+radius*Math.cos(angle*speed));
            break;
        }
    }
}
