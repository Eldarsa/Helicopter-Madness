package com.mygdx.helicopter_madness;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.helicopter_madness.states.GameStateManager;
import com.mygdx.helicopter_madness.states.MenuState;

public class HelicopterMadness extends ApplicationAdapter {
	public static final int WIDTH = 480;  // Change to fit phone
	public static final int HEIGHT = 800;

	public static final String TITLE = "Helicopter madness";
	private GameStateManager gsm;
	private SpriteBatch sb;
//	SpriteBatch batch;
//	Texture img;
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		gsm = new GameStateManager();
//		img = new Texture("badlogic.jpg");
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		sb.dispose();
//		img.dispose();
	}
}
