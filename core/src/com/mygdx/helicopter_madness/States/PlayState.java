package com.mygdx.helicopter_madness.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.helicopter_madness.HelicopterMadness;
import com.mygdx.helicopter_madness.Sprites.Helicopter;

public class PlayState extends State {
    private Helicopter helicopter;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        helicopter = new Helicopter(10, 10);
        //cam.setToOrtho(false, HelicopterMadness.WIDTH / 2, HelicopterMadness.HEIGHT /2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        helicopter.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(helicopter.getHelicopter(), helicopter.getPosition().x, helicopter.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
