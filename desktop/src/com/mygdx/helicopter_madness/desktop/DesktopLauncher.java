package com.mygdx.helicopter_madness.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.helicopter_madness.HelicopterMadness;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = HelicopterMadness.WIDTH;
		config.height = HelicopterMadness.HEIGHT;
		config.title = HelicopterMadness.TITLE;
		new LwjglApplication(new HelicopterMadness(), config);
	}
}
