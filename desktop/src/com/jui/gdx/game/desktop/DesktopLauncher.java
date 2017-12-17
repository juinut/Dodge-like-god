package com.jui.gdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jui.gdx.game.DodgeLikeGodGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = DodgeLikeGodGame.WIDTH;
        config.height = DodgeLikeGodGame.HEIGHT;
		new LwjglApplication(new DodgeLikeGodGame(), config);
	}

}

