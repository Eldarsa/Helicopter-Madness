package com.mygdx.helicopter_madness.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.helicopter_madness.HelicopterMadness;
import com.mygdx.helicopter_madness.sprites.Helicopter;

public class PlayState extends State{
    private Helicopter helicopter;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        helicopter = new Helicopter(100, 100, 20, 25);
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
        sb.begin();
        sb.draw(helicopter.getTexture(), helicopter.getPos().x, helicopter.getPos().y, helicopter.getTexture().getWidth(), helicopter.getTexture().getHeight(), 0, 0, helicopter.getTexture().getWidth(), helicopter.getTexture().getHeight(), helicopter.isFlipX(), false);
//        sb.draw(helicopter.getTexture(), helicopter.getPos().x, helicopter.getPos().y, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, helicopter.isFlipX(), false);
        sb.end();
    }

    @Override
    public void dispose() {
        helicopter.dispose();
    }

}
