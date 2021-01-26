package com.mygdx.helicopter_madness.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.helicopter_madness.HelicopterMadness;

public class MenuState extends State{
    private Texture playBtn;

    public MenuState(GameStateManager gsm){
        super(gsm);
        playBtn = new Texture("playbtn.PNG");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(playBtn, (HelicopterMadness.WIDTH/2) - (playBtn.getWidth()/2), HelicopterMadness.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
        playBtn.dispose();
    }
}
