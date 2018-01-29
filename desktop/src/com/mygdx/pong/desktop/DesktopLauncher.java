package com.mygdx.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.pong.Game.GamePong;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Uhhh you touch my PO PO POOOONG";
		config.width = 600;
		config.height = 500;
		new LwjglApplication(new GamePong(), config);
	}
}
